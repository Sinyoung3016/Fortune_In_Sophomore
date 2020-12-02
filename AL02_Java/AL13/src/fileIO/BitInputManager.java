
package fileIO;

import java.io.IOException;

public class BitInputManager {
	private ExtendedBufferedInputStream _bitInputStream;
	private int _bitBuffer;
	private int _numberOfBitsInBuffer;

	private ExtendedBufferedInputStream bitInputStream() {
		return this._bitInputStream;
	}
	private void setBitInputStream(ExtendedBufferedInputStream newBitOutputStream) {
		this._bitInputStream = newBitOutputStream;
	}
	private int bitBuffer() {
		return this._bitBuffer;
	}
	private void setBitBuffer(int newBitBuffer) {
		this._bitBuffer = newBitBuffer;
	}
	private int numberOfBitsInBuffer() {
		return this._numberOfBitsInBuffer;
	}
	private void setNumberOfBitsInBuffer(int newNumberOfBitsInBuffer) {
		this._numberOfBitsInBuffer = newNumberOfBitsInBuffer;
	}

	public BitInputManager(ExtendedBufferedInputStream givenBitOutputStream) {
		this.setBitInputStream(givenBitOutputStream);
		this.setNumberOfBitsInBuffer(0);
		this.setBitBuffer(0);
	}

	public int readBit() throws IOException {
		if (this.numberOfBitsInBuffer() == 0) {
			this.setBitBuffer(this.bitInputStream().read());
			this.setNumberOfBitsInBuffer(8);
		}
		this.setNumberOfBitsInBuffer(this.numberOfBitsInBuffer() - 1);
		return this.bitBuffer() >> this.numberOfBitsInBuffer() & 1;
	}
}
