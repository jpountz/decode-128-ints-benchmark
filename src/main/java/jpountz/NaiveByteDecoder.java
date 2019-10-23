package jpountz;

import java.nio.ByteBuffer;

/**
 * Naive decoding of packed longs that reads bytes.
 */
public class NaiveByteDecoder {

  static void decode(int bitsPerValue, ByteBuffer in, byte[] tmp, int[] values) {
    in.get(tmp, 0, bitsPerValue << 4);
    switch (bitsPerValue) {
    case 1:
      decode1(tmp, values);
      break;
    case 2:
      decode2(tmp, values);
      break;
    case 3:
      decode3(tmp, values);
      break;
    case 4:
      decode4(tmp, values);
      break;
    case 5:
      decode5(tmp, values);
      break;
    case 6:
      decode6(tmp, values);
      break;
    case 7:
      decode7(tmp, values);
      break;
    case 8:
      decode8(tmp, values);
      break;
    case 9:
      decode9(tmp, values);
      break;
    case 10:
      decode10(tmp, values);
      break;
    case 11:
      decode11(tmp, values);
      break;
    case 12:
      decode12(tmp, values);
      break;
    case 13:
      decode13(tmp, values);
      break;
    case 14:
      decode14(tmp, values);
      break;
    case 15:
      decode15(tmp, values);
      break;
    case 16:
      decode16(tmp, values);
      break;
    default:
      throw new Error();
    }
  }

  private static void decode1(byte[] blocks, int[] values) {
    int blocksOffset = 0;
    int valuesOffset = 0;
    for (int j = 0; j < 16; ++j) {
      final byte block = blocks[blocksOffset++];
      values[valuesOffset++] = (block >>> 7) & 1;
      values[valuesOffset++] = (block >>> 6) & 1;
      values[valuesOffset++] = (block >>> 5) & 1;
      values[valuesOffset++] = (block >>> 4) & 1;
      values[valuesOffset++] = (block >>> 3) & 1;
      values[valuesOffset++] = (block >>> 2) & 1;
      values[valuesOffset++] = (block >>> 1) & 1;
      values[valuesOffset++] = block & 1;
    }
  }

  private static void decode2(byte[] blocks, int[] values) {
    int blocksOffset = 0;
    int valuesOffset = 0;
    for (int j = 0; j < 32; ++j) {
      final byte block = blocks[blocksOffset++];
      values[valuesOffset++] = (block >>> 6) & 3;
      values[valuesOffset++] = (block >>> 4) & 3;
      values[valuesOffset++] = (block >>> 2) & 3;
      values[valuesOffset++] = block & 3;
    }
  }

  private static void decode3(byte[] blocks, int[] values) {
    int blocksOffset = 0;
    int valuesOffset = 0;
    for (int i = 0; i < 16; ++i) {
      final int byte0 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = byte0 >>> 5;
      values[valuesOffset++] = (byte0 >>> 2) & 7;
      final int byte1 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte0 & 3) << 1) | (byte1 >>> 7);
      values[valuesOffset++] = (byte1 >>> 4) & 7;
      values[valuesOffset++] = (byte1 >>> 1) & 7;
      final int byte2 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte1 & 1) << 2) | (byte2 >>> 6);
      values[valuesOffset++] = (byte2 >>> 3) & 7;
      values[valuesOffset++] = byte2 & 7;
    }
  }

  private static void decode4(byte[] blocks, int[] values) {
    int blocksOffset = 0;
    int valuesOffset = 0;
    for (int j = 0; j < 64; ++j) {
      final byte block = blocks[blocksOffset++];
      values[valuesOffset++] = (block >>> 4) & 15;
      values[valuesOffset++] = block & 15;
    }
  }

  private static void decode5(byte[] blocks, int[] values) {
    int blocksOffset = 0;
    int valuesOffset = 0;
    for (int j = 0; j < 16; ++j) {
      final int byte0 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = byte0 >>> 3;
      final int byte1 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte0 & 7) << 2) | (byte1 >>> 6);
      values[valuesOffset++] = (byte1 >>> 1) & 31;
      final int byte2 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte1 & 1) << 4) | (byte2 >>> 4);
      final int byte3 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte2 & 15) << 1) | (byte3 >>> 7);
      values[valuesOffset++] = (byte3 >>> 2) & 31;
      final int byte4 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte3 & 3) << 3) | (byte4 >>> 5);
      values[valuesOffset++] = byte4 & 31;
    }
  }

  private static void decode6(byte[] blocks, int[] values) {
    int blocksOffset = 0;
    int valuesOffset = 0;
    for (int k = 0; k < 32; ++k) {
      final int byte0 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = byte0 >>> 2;
      final int byte1 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte0 & 3) << 4) | (byte1 >>> 4);
      final int byte2 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte1 & 15) << 2) | (byte2 >>> 6);
      values[valuesOffset++] = byte2 & 63;
    }
  }

  private static void decode7(byte[] blocks, int[] values) {
    int blocksOffset = 0;
    int valuesOffset = 0;
    for (int k = 0; k < 16; ++k) {
      final int byte0 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = byte0 >>> 1;
      final int byte1 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte0 & 1) << 6) | (byte1 >>> 2);
      final int byte2 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte1 & 3) << 5) | (byte2 >>> 3);
      final int byte3 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte2 & 7) << 4) | (byte3 >>> 4);
      final int byte4 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte3 & 15) << 3) | (byte4 >>> 5);
      final int byte5 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte4 & 31) << 2) | (byte5 >>> 6);
      final int byte6 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte5 & 63) << 1) | (byte6 >>> 7);
      values[valuesOffset++] = byte6 & 127;
    }
  }

  private static void decode8(byte[] blocks, int[] values) {
    int blocksOffset = 0;
    int valuesOffset = 0;
    for (int j = 0; j < 128; ++j) {
      values[valuesOffset++] = blocks[blocksOffset++] & 0xFF;
    }
  }

  private static void decode9(byte[] blocks, int[] values) {
    int blocksOffset = 0;
    int valuesOffset = 0;
    for (int j = 0; j < 16; ++j) {
      final int byte0 = blocks[blocksOffset++] & 0xFF;
      final int byte1 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = (byte0 << 1) | (byte1 >>> 7);
      final int byte2 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte1 & 127) << 2) | (byte2 >>> 6);
      final int byte3 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte2 & 63) << 3) | (byte3 >>> 5);
      final int byte4 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte3 & 31) << 4) | (byte4 >>> 4);
      final int byte5 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte4 & 15) << 5) | (byte5 >>> 3);
      final int byte6 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte5 & 7) << 6) | (byte6 >>> 2);
      final int byte7 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte6 & 3) << 7) | (byte7 >>> 1);
      final int byte8 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte7 & 1) << 8) | byte8;
    }
  }

  private static void decode10(byte[] blocks, int[] values) {
    int blocksOffset = 0;
    int valuesOffset = 0;
    for (int j = 0; j < 32; ++j) {
      final int byte0 = blocks[blocksOffset++] & 0xFF;
      final int byte1 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = (byte0 << 2) | (byte1 >>> 6);
      final int byte2 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte1 & 63) << 4) | (byte2 >>> 4);
      final int byte3 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte2 & 15) << 6) | (byte3 >>> 2);
      final int byte4 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte3 & 3) << 8) | byte4;
    }
  }

  private static void decode11(byte[] blocks, int[] values) {
    int blocksOffset = 0;
    int valuesOffset = 0;
    for (int j = 0; j < 16; ++j) {
      final int byte0 = blocks[blocksOffset++] & 0xFF;
      final int byte1 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = (byte0 << 3) | (byte1 >>> 5);
      final int byte2 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte1 & 31) << 6) | (byte2 >>> 2);
      final int byte3 = blocks[blocksOffset++] & 0xFF;
      final int byte4 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte2 & 3) << 9) | (byte3 << 1) | (byte4 >>> 7);
      final int byte5 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte4 & 127) << 4) | (byte5 >>> 4);
      final int byte6 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte5 & 15) << 7) | (byte6 >>> 1);
      final int byte7 = blocks[blocksOffset++] & 0xFF;
      final int byte8 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte6 & 1) << 10) | (byte7 << 2) | (byte8 >>> 6);
      final int byte9 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte8 & 63) << 5) | (byte9 >>> 3);
      final int byte10 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte9 & 7) << 8) | byte10;
    }
  }

  private static void decode12(byte[] blocks, int[] values) {
    int blocksOffset = 0;
    int valuesOffset = 0;
    for (int j = 0; j < 64; ++j) {
      final int byte0 = blocks[blocksOffset++] & 0xFF;
      final int byte1 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = (byte0 << 4) | (byte1 >>> 4);
      final int byte2 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte1 & 15) << 8) | byte2;
    }
  }

  private static void decode13(byte[] blocks, int[] values) {
    int blocksOffset = 0;
    int valuesOffset = 0;
    for (int j = 0; j < 16; ++j) {
      final int byte0 = blocks[blocksOffset++] & 0xFF;
      final int byte1 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = (byte0 << 5) | (byte1 >>> 3);
      final int byte2 = blocks[blocksOffset++] & 0xFF;
      final int byte3 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte1 & 7) << 10) | (byte2 << 2) | (byte3 >>> 6);
      final int byte4 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte3 & 63) << 7) | (byte4 >>> 1);
      final int byte5 = blocks[blocksOffset++] & 0xFF;
      final int byte6 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte4 & 1) << 12) | (byte5 << 4) | (byte6 >>> 4);
      final int byte7 = blocks[blocksOffset++] & 0xFF;
      final int byte8 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte6 & 15) << 9) | (byte7 << 1) | (byte8 >>> 7);
      final int byte9 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte8 & 127) << 6) | (byte9 >>> 2);
      final int byte10 = blocks[blocksOffset++] & 0xFF;
      final int byte11 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte9 & 3) << 11) | (byte10 << 3) | (byte11 >>> 5);
      final int byte12 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte11 & 31) << 8) | byte12;
    }
  }

  private static void decode14(byte[] blocks, int[] values) {
    int blocksOffset = 0;
    int valuesOffset = 0;
    for (int j = 0; j < 16; ++j) {
      final int byte0 = blocks[blocksOffset++] & 0xFF;
      final int byte1 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = (byte0 << 6) | (byte1 >>> 2);
      final int byte2 = blocks[blocksOffset++] & 0xFF;
      final int byte3 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte1 & 3) << 12) | (byte2 << 4) | (byte3 >>> 4);
      final int byte4 = blocks[blocksOffset++] & 0xFF;
      final int byte5 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte3 & 15) << 10) | (byte4 << 2) | (byte5 >>> 6);
      final int byte6 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte5 & 63) << 8) | byte6;
    }
  }

  private static void decode15(byte[] blocks, int[] values) {
    int blocksOffset = 0;
    int valuesOffset = 0;
    for (int j = 0; j < 16; ++j) {
      final int byte0 = blocks[blocksOffset++] & 0xFF;
      final int byte1 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = (byte0 << 7) | (byte1 >>> 1);
      final int byte2 = blocks[blocksOffset++] & 0xFF;
      final int byte3 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte1 & 1) << 14) | (byte2 << 6) | (byte3 >>> 2);
      final int byte4 = blocks[blocksOffset++] & 0xFF;
      final int byte5 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte3 & 3) << 13) | (byte4 << 5) | (byte5 >>> 3);
      final int byte6 = blocks[blocksOffset++] & 0xFF;
      final int byte7 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte5 & 7) << 12) | (byte6 << 4) | (byte7 >>> 4);
      final int byte8 = blocks[blocksOffset++] & 0xFF;
      final int byte9 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte7 & 15) << 11) | (byte8 << 3) | (byte9 >>> 5);
      final int byte10 = blocks[blocksOffset++] & 0xFF;
      final int byte11 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte9 & 31) << 10) | (byte10 << 2) | (byte11 >>> 6);
      final int byte12 = blocks[blocksOffset++] & 0xFF;
      final int byte13 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte11 & 63) << 9) | (byte12 << 1) | (byte13 >>> 7);
      final int byte14 = blocks[blocksOffset++] & 0xFF;
      values[valuesOffset++] = ((byte13 & 127) << 8) | byte14;
    }
  }

  private static void decode16(byte[] blocks, int[] values) {
    int blocksOffset = 0;
    int valuesOffset = 0;
    for (int j = 0; j < 128; ++j) {
      values[valuesOffset++] = ((blocks[blocksOffset++] & 0xFF) << 8) | (blocks[blocksOffset++] & 0xFF);
    }
  }

}
