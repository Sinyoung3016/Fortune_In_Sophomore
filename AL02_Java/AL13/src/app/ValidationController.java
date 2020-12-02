package app;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ValidationController {
	private File _firstFile;
	private File _secondFile;

	private String _firstFilePath;

	private BufferedInputStream _firstInputStream;
	private BufferedInputStream _secondInputStream;

	private File firstFile() {
		return this._firstFile;
	}
	private void setFirstFile(File newFirstFile) {
		this._firstFile = newFirstFile;
	}
	private File secondFile() {
		return this._secondFile;
	}
	private void setSecondFile(File newSecondFile) {
		this._secondFile = newSecondFile;
	}
	private String firstFilePath() {
		return this._firstFilePath;
	}
	private void setFirstFilePath(String newFirstFilePath) {
		this._firstFilePath = newFirstFilePath;
	}
	private BufferedInputStream firstInputStream() {
		return this._firstInputStream;
	}
	private void setFirstInputStream(BufferedInputStream newFirstInputStream) {
		this._firstInputStream = newFirstInputStream;
	}
	private BufferedInputStream secondInputStream() {
		return this._secondInputStream;
	}
	private void setSecondInputStream(BufferedInputStream newSecondInputStream) {
		this._secondInputStream = newSecondInputStream;
	}

	private boolean initFirstFile() {
		AppView.outputLine("");
		AppView.outputLine("? 첫 번째 파일의 경로와 이름을 입력하시오 : ");
		this.setFirstFilePath(AppView.inputFilePath());
		String fileName = AppView.inputFileName();
		String filePathAndName = this.firstFilePath() + "/" + fileName;
		this.setFirstFile(new File(filePathAndName));
		if (this.firstFile().exists())
			return true;
		else {
			AppView.outputLine("!오류: 파일 (" + filePathAndName + ") 이 존재하지 않습니다.");
			return false;
		}
	}

	private boolean initSecondFile() {
		AppView.outputLine("");
		AppView.outputLine("? 두 번째 파일의 경로와 이름을 입력하시오 : ");
		String filePath;
		if (AppView.inputAnswerForUsingSamePath())
			filePath = this.firstFilePath();
		 else filePath = AppView.inputFilePath();

		String fileName = AppView.inputFileName();
		String filePathAndName = filePath + "/" + fileName;
		this.setSecondFile(new File(filePathAndName));
		if (this.secondFile().exists()) {
			return true;
		} else {
			AppView.outputLine("!오류: 파일 (" + filePathAndName + ") 이 존재하지 않습니다.");
			return false;
		}
	}

	private BufferedInputStream openInputStream(File file) throws IOException {
		try {
			return new BufferedInputStream(new FileInputStream(file));
		} catch (IOException e) {
			AppView.outputLine("!오류 : 파일을 열 수 없습니다.");
			throw e;
		}
	}

	private void closeInputStream(BufferedInputStream bufferedInputStream, File inputFile) throws IOException {
		try {
			bufferedInputStream.close();
		} catch (IOException e) {
			AppView.outputLine("!오류: 파일 닫기를 실패했습니다.");
			throw e;
		}
	}

	private int readByteFromFirstInputStream() throws IOException {
		try {
			return this.firstInputStream().read();
		} catch (IOException e) {
			AppView.outputLine("!오류: 첫번째 파일 읽기를 실패하였습니다.");
			throw e;
		}
	}

	private int readByteFromSecondInputStream() throws IOException {
		try {
			return this.secondInputStream().read();
		} catch (IOException e) {
			AppView.outputLine("!오류: 두번째 파일 읽기를 실패하였습니다.");
			throw e;
		}
	}

	private boolean validate() throws IOException {
		int byteOfFirstFile = this.readByteFromFirstInputStream();
		int byteOfSecondFile = this.readByteFromSecondInputStream();
		while (byteOfFirstFile == byteOfSecondFile) {
			byteOfFirstFile = this.readByteFromFirstInputStream();
			byteOfSecondFile = this.readByteFromSecondInputStream();
			if ((byteOfFirstFile == -1) || (byteOfFirstFile == -1)) {
				break;
			}
		}
		return (byteOfFirstFile == -1) && (byteOfSecondFile == -1);
	}

	protected ValidationController() {
	}

	protected void run() {
		if (this.initFirstFile() && this.initSecondFile()) {
			try {
				this.setFirstInputStream(this.openInputStream(this.firstFile()));
				this.setSecondInputStream(this.openInputStream(this.secondFile()));
				if (this.validate()) {
					AppView.outputLine("두 파일은 일치한 파일 입니다.");
				} else {
					AppView.outputLine("두 파일은 일치하지 않는 파일입니다.");
				}
				this.closeInputStream(this.firstInputStream(), this.firstFile());
				this.closeInputStream(this.secondInputStream(), this.secondFile());
			} catch (IOException e) {
				AppView.outputLine("");
			}
		}

	}
}
