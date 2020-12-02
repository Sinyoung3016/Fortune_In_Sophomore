package huffman;

public class HuffmanDecoder {
	private short[][] _serializedHuffmanTree;
	private int _currentNodeIndex;

	public short[][] serializedHuffmanTree() {
		return this._serializedHuffmanTree;
	}
	private void setSerializedHuffmanTree(short[][] newSerializedHuffmanTree) {
		this._serializedHuffmanTree = newSerializedHuffmanTree;
	}
	private int currentNodeIndex() {
		return this._currentNodeIndex;
	}
	private void setCurrentNodeIndex(int newCurrentNodeIndex) {
		this._currentNodeIndex = newCurrentNodeIndex;
	}
	public HuffmanDecoder(short[][] givenSerializedHuffmanTree) {
		this.setSerializedHuffmanTree(givenSerializedHuffmanTree);
		this.setCurrentNodeIndex(0);
	}

	public int decodeBit(int bitValue) {
		int returnNumber = -1;
		if (bitValue == Huffman_CONST.LEFT_OF_NODE) {
			this.setCurrentNodeIndex(this.serializedHuffmanTree()[this.currentNodeIndex()][Huffman_CONST.LEFT_OF_NODE]);
		} else if (bitValue == Huffman_CONST.RIGHT_OF_NODE) {
			this.setCurrentNodeIndex(this.serializedHuffmanTree()[this.currentNodeIndex()][Huffman_CONST.RIGHT_OF_NODE]);
		}
		if (this.serializedHuffmanTree()[this.currentNodeIndex()][Huffman_CONST.LEFT_OF_NODE] == -1) {
			returnNumber = this.serializedHuffmanTree()[this.currentNodeIndex()][Huffman_CONST.RIGHT_OF_NODE];
			this.setCurrentNodeIndex(Huffman_CONST.ROOT_NODE_INDEX);
		}
		return returnNumber;
	}
}
