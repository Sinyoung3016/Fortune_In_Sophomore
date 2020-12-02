package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import fileIO.BitInputManager;
import fileIO.ExtendedBufferedInputStream;
import fileIO.ExtendedBufferedOutputStream;
import fileIO.FileIO_CONST;
import fileIO.FilePathManager;
import huffman.HuffmanDecoder;
import huffman.Huffman_CONST;

public class DecompressionController {

	private File _compressedFile;
	private File _decompressedFile;
	private ExtendedBufferedInputStream _compressedInputStream;
	private ExtendedBufferedOutputStream _decompressedOutputStream;
	private BitInputManager _bitInputManager;
	private HuffmanDecoder _huffmanDecoder;

	private File compressedFile() {
		return this._compressedFile;
	}
	private void setCompressedFile(File newCompressedFile) {
		this._compressedFile = newCompressedFile;
	}
	private File decompressedFile() {
		return this._decompressedFile;
	}
	private void setDecompressedFile(File newDecompressedFile) {
		this._decompressedFile = newDecompressedFile;
	}
	private ExtendedBufferedInputStream compressedInputStream() {
		return this._compressedInputStream;
	}
	private void setCompressedInputStream(ExtendedBufferedInputStream newCompressedInputStream) {
		this._compressedInputStream = newCompressedInputStream;
	}
	private ExtendedBufferedOutputStream decompressedOutputStream() {
		return _decompressedOutputStream;
	}
	private void setDecompressedOutputStream(ExtendedBufferedOutputStream _decompressedOutputStream) {
		this._decompressedOutputStream = _decompressedOutputStream;
	}
	private BitInputManager bitInputManager() {
		return this._bitInputManager;
	}
	private void setBitInputManager(BitInputManager newBitInputManager) {
		this._bitInputManager = newBitInputManager;
	}
	private HuffmanDecoder huffmanDecoder() {
		return this._huffmanDecoder;
	}
	private void setHuffmanDecoder(HuffmanDecoder newHuffmanDecoder) {
		this._huffmanDecoder = newHuffmanDecoder;
	}

	private boolean initCompressedFile() {
		AppView.outputLine("");
		AppView.outputLine("? 압축을 풀 파일의 경로와 이름을 입력하시오 : ");
		String filePath = AppView.inputFilePath();
		String fileName = AppView.inputFileName();
		String filePathAndName = filePath + "/" + fileName;
		this.setCompressedFile(new File(filePathAndName));
		if (this.compressedFile().exists() && FilePathManager.getFileExtension(this.compressedFile()).equals(App_CONST.COMPRESSED_FILE_EXTENSION)) {
			return true;
		} else {
			AppView.outputLine("!오류: 압축 파일 (" + filePathAndName + ") 이 존재하지 않습니다.");
			return false;
		}
	}

	private void initDecompressedFile() {
		AppView.outputLine("");
		String filePathAndName = FilePathManager.getFilePathAndNameWithoutExtension(this.compressedFile());
		this.setDecompressedFile(new File(filePathAndName));
		if (this.decompressedFile().exists()) {
			AppView.outputLine("!경고: 압축 해제 파일 (" + filePathAndName + ") 이 이미 존재합니다.");
			AppView.outputLine("- 압축 해제 파일의 이름을 다른 것으로 바꾸어 처리합니다:");
			String decompressedFilePathAndNameWithoutExtension = FilePathManager.getFilePathAndNameWithoutExtension(this.decompressedFile());
			String decompressedFilePathAndNameWithInfix = decompressedFilePathAndNameWithoutExtension + "_UNZIP_";
			String decompressedFilePathAndName = null;
			int decompressedFileSerialNumber = 0;
			do {
				decompressedFileSerialNumber++;
				decompressedFilePathAndName = decompressedFilePathAndNameWithInfix + decompressedFileSerialNumber + ".txt";
				this.setDecompressedFile(new File(decompressedFilePathAndName));
			} while(this.decompressedFile().exists());

			AppView.outputLine("- 새로운 압축 해제 파일의 이름은" + decompressedFilePathAndName + " 입니다.");
		}

	}

	private short[][] readSerializedHuffmanTree() throws IOException {
		short numberOfTheTreeNodeLength = this.compressedInputStream().readShort();
		short serializedHuffmanTree[][] = new short[numberOfTheTreeNodeLength][2];
		for (int i = 0; i < numberOfTheTreeNodeLength; i++) {
			try {
				serializedHuffmanTree[i][Huffman_CONST.LEFT_OF_NODE] = this.compressedInputStream().readShort();
				serializedHuffmanTree[i][Huffman_CONST.RIGHT_OF_NODE] = this.compressedInputStream().readShort();
			} catch (IOException e) {
				AppView.outputLine("!오류 : [직렬화된 허프만 트리]를 파일에서 읽어 들이는 작업을 실패 하였습니다.");
				throw e;
			}
		}
		return serializedHuffmanTree;
	}

	private long readNumberOfBitsOfCompressedData() throws IOException {		long numberOfBitsOfCompressedData;
		try {
			return this.compressedInputStream().readLong();
		} catch (IOException e) {
			AppView.outputLine("!오류 : [압축된 데이터의 비트 수]를 파일에 읽어오는 작업을 실패하였습니다.");
			throw e;
		}
	}

	private void openDecompressedOutputStream() throws IOException {
		try {
			FileOutputStream deCompressedOutputStream = new FileOutputStream(this.decompressedFile());
			this.setDecompressedOutputStream(new ExtendedBufferedOutputStream(deCompressedOutputStream));
		} catch (IOException e) {
			AppView.outputLine("!오류 : 압축 해제할 파일을 열 수 없습니다.");
			throw e;
		}
	}

	private void openCompressedInputStream() throws IOException {
		try {
			FileInputStream compressedInputStream = new FileInputStream(this.compressedFile());
			this.setCompressedInputStream(new ExtendedBufferedInputStream(compressedInputStream));
		} catch (IOException e) {
			AppView.outputLine("!오류 : 압축된 파일을 열 수 없습니다ㅏ.");
			throw e;
		}
	}

	private void writeDecompressedBits() throws IOException {
		try {
			long numberOfData = this.readNumberOfBitsOfCompressedData();
			for(long i = 0; i < numberOfData; i++) {
				int bits = this.bitInputManager().readBit();
				int decoded = this.huffmanDecoder().decodeBit(bits);
				if (decoded != -1) {
					this.decompressedOutputStream().write(decoded);
				}
			}

		} catch (IOException e) {
			AppView.outputLine("!오류 : 압축 파일에 비트 데이터 쓰기를 실패하였습니다.");
			throw e;
		}
	}

	private void closeCompressedInputStream() throws IOException {
		try {
			this.compressedInputStream().close();
		} catch (IOException e) {
			AppView.outputLine("!오류 : 원본 파일 닫기를 실패하였습니다.");
			throw e;
		}
	}

	private void closeDecompressedOutputStream() throws IOException {
		try {
			this.decompressedOutputStream().close();
		} catch (IOException e) {
			AppView.outputLine("!오류 : 원본 파일 닫기를 실패 하였습니다.");
			throw e;
		}
	}

	private void showStatistics() {
		AppView.outputLine("> 압축해제 정보 : ");
		long compressedFileSize = this.compressedFile().length();
		long deCompressedFileSize = this.decompressedFile().length();
		AppView.outputLine(
				"- 원본 파일 : " + this.compressedFile().getAbsolutePath() + " (" + compressedFileSize + " Byte)");
		AppView.outputLine(
				"- 압축 해제 파일 : " + this.decompressedFile().getAbsolutePath() + " (" + deCompressedFileSize + " Byte)");
	}

	protected DecompressionController() {
	}

	private void decompressed() throws IOException {
		this.openCompressedInputStream();
		this.openDecompressedOutputStream();

		this.setBitInputManager(new BitInputManager(this.compressedInputStream()));
		short[][] newShortFile = this.readSerializedHuffmanTree();
		this.setHuffmanDecoder(new HuffmanDecoder(newShortFile));
		this.writeDecompressedBits();

		this.closeDecompressedOutputStream();
		this.closeCompressedInputStream();

		return;
	}

	protected void run() {
		if (this.initCompressedFile()) {
			this.initDecompressedFile();
			try {
				this.decompressed();
				AppView.outputLine("");
				AppView.outputLine("! 압축해제를 성공적으로 마쳤습니다.");
				this.showStatistics();
			} catch (IOException e) {
				AppView.outputLine("!오류 : 압축해제 실행하는 동안에 파일 처리 오류가 발생하였습니다.");
			}
		}
	}
}
