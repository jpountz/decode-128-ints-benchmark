package jpountz;

import java.nio.ByteBuffer;

/**
 * Same as {@link SIMDDecoder} but goes one step further and encodes 4 shorts
 * on a long. It cannot handle more than 16 bits per value.
 */
public class SIMDDecoder2 {

  private static long expandMask(long mask16) {
    long mask32 = mask16 | (mask16 << 16);
    return mask32 | (mask32 << 32);
  }

  private static long mask(int bitsPerValue) {
    return expandMask((1L << bitsPerValue) - 1);
  }

  private static final long MASK_1 = mask(1);
  private static final long MASK_2 = mask(2);
  private static final long MASK_3 = mask(3);
  private static final long MASK_4 = mask(4);
  private static final long MASK_5 = mask(5);
  private static final long MASK_6 = mask(6);
  private static final long MASK_7 = mask(7);
  private static final long MASK_8 = mask(8);
  private static final long MASK_9 = mask(9);
  private static final long MASK_10 = mask(10);
  private static final long MASK_11 = mask(11);
  private static final long MASK_12 = mask(12);
  private static final long MASK_13 = mask(13);
  private static final long MASK_14 = mask(14);
  private static final long MASK_15 = mask(15);
  private static final long MASK_16 = mask(16);

  static void decode(int bitsPerValue, ByteBuffer in, long[] longs) {
    switch (bitsPerValue) {
    case 1:
      decode1(in, longs);
      break;
    case 2:
      decode2(in, longs);
      break;
    case 3:
      decode3(in, longs);
      break;
    case 4:
      decode4(in, longs);
      break;
    case 5:
      decode5(in, longs);
      break;
    case 6:
      decode6(in, longs);
      break;
    case 7:
      decode7(in, longs);
      break;
    case 8:
      decode8(in, longs);
      break;
    case 9:
      decode9(in, longs);
      break;
    case 10:
      decode10(in, longs);
      break;
    case 11:
      decode11(in, longs);
      break;
    case 12:
      decode12(in, longs);
      break;
    case 13:
      decode13(in, longs);
      break;
    case 14:
      decode14(in, longs);
      break;
    case 15:
      decode15(in, longs);
      break;
    case 16:
      decode16(in, longs);
      break;
    default:
      throw new Error();
    }
  }

  private static void decode1(ByteBuffer in, long[] intQuads) {
    int idx = 0;
    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 15; shift >= 0; shift -= 1) {
        intQuads[idx++] = (block0 >>> shift) & MASK_1;
      }
    }
  }

  private static void decode2(ByteBuffer in, long[] intQuads) {
    int idx = 0;
    for (int k = 0; k < 4; ++k) {
      long block0 = in.getLong();
      for (int shift = 14; shift >= 0; shift -= 2) {
        intQuads[idx++] = (block0 >>> shift) & MASK_2;
      }
    }
  }

  private static void decode3(ByteBuffer in, long[] intQuads) {
    int idx = 0;
    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 13; shift >= 0; shift -= 3) {
        intQuads[idx++] = (block0 >>> shift) & MASK_3;
      }
      long block1 = in.getLong();
      intQuads[idx++] = ((block0 & MASK_1) << 2) | ((block1 >>> 14) & MASK_2);
      for (int shift = 11; shift >= 0; shift -= 3) {
        intQuads[idx++] = (block1 >>> shift) & MASK_3;
      }
      long block2 = in.getLong();
      intQuads[idx++] = ((block1 & MASK_2) << 1) | ((block2 >>> 15) & MASK_1);
      for (int shift = 12; shift >= 0; shift -= 3) {
        intQuads[idx++] = (block2 >>> shift) & MASK_3;
      }
    }
  }

  private static void decode4(ByteBuffer in, long[] intQuads) {
    int idx = 0;
    for (int k = 0; k < 8; ++k) {
      long block0 = in.getLong();
      for (int shift = 12; shift >= 0; shift -= 4) {
        intQuads[idx++] = (block0 >>> shift) & MASK_4;
      }
    }
  }

  private static void decode5(ByteBuffer in, long[] intQuads) {
    int idx = 0;
    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 11; shift >= 0; shift -= 5) {
        intQuads[idx++] = (block0 >>> shift) & MASK_5;
      }
      long block1 = in.getLong();
      intQuads[idx++] = ((block0 & MASK_1) << 4) | ((block1 >>> 12) & MASK_4);
      for (int shift = 7; shift >= 0; shift -= 5) {
        intQuads[idx++] = (block1 >>> shift) & MASK_5;
      }
      long block2 = in.getLong();
      intQuads[idx++] = ((block1 & MASK_2) << 3) | ((block2 >>> 13) & MASK_3);
      for (int shift = 8; shift >= 0; shift -= 5) {
        intQuads[idx++] = (block2 >>> shift) & MASK_5;
      }
      long block3 = in.getLong();
      intQuads[idx++] = ((block2 & MASK_3) << 2) | ((block3 >>> 14) & MASK_2);
      for (int shift = 9; shift >= 0; shift -= 5) {
        intQuads[idx++] = (block3 >>> shift) & MASK_5;
      }
      long block4 = in.getLong();
      intQuads[idx++] = ((block3 & MASK_4) << 1) | ((block4 >>> 15) & MASK_1);
      for (int shift = 10; shift >= 0; shift -= 5) {
        intQuads[idx++] = (block4 >>> shift) & MASK_5;
      }
    }
  }

  private static void decode6(ByteBuffer in, long[] intQuads) {
    int idx = 0;
    for (int k = 0; k < 4; ++k) {
      long block0 = in.getLong();
      for (int shift = 10; shift >= 0; shift -= 6) {
        intQuads[idx++] = (block0 >>> shift) & MASK_6;
      }
      long block1 = in.getLong();
      intQuads[idx++] = ((block0 & MASK_4) << 2) | ((block1 >>> 14) & MASK_2);
      for (int shift = 8; shift >= 0; shift -= 6) {
        intQuads[idx++] = (block1 >>> shift) & MASK_6;
      }
      long block2 = in.getLong();
      intQuads[idx++] = ((block1 & MASK_2) << 4) | ((block2 >>> 12) & MASK_4);
      for (int shift = 6; shift >= 0; shift -= 6) {
        intQuads[idx++] = (block2 >>> shift) & MASK_6;
      }
    }
  }

  private static void decode7(ByteBuffer in, long[] intQuads) {
    int idx = 0;
    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 9; shift >= 0; shift -= 7) {
        intQuads[idx++] = (block0 >>> shift) & MASK_7;
      }
      long block1 = in.getLong();
      intQuads[idx++] = ((block0 & MASK_2) << 5) | ((block1 >>> 11) & MASK_5);
      intQuads[idx++] = (block1 >>> 4) & MASK_7;
      long block2 = in.getLong();
      intQuads[idx++] = ((block1 & MASK_4) << 3) | ((block2 >>> 13) & MASK_3);
      intQuads[idx++] = (block2 >>> 6) & MASK_7;
      long block3 = in.getLong();
      intQuads[idx++] = ((block2 & MASK_6) << 1) | ((block3 >>> 15) & MASK_1);
      for (int shift = 8; shift >= 0; shift -= 7) {
        intQuads[idx++] = (block3 >>> shift) & MASK_7;
      }
      long block4 = in.getLong();
      intQuads[idx++] = ((block3 & MASK_1) << 6) | ((block4 >>> 10) & MASK_6);
      intQuads[idx++] = (block4 >>> 3) & MASK_7;
      long block5 = in.getLong();
      intQuads[idx++] = ((block4 & MASK_3) << 4) | ((block5 >>> 12) & MASK_4);
      intQuads[idx++] = (block5 >>> 5) & MASK_7;
      long block6 = in.getLong();
      intQuads[idx++] = ((block5 & MASK_5) << 2) | ((block6 >>> 14) & MASK_2);
      for (int shift = 7; shift >= 0; shift -= 7) {
        intQuads[idx++] = (block6 >>> shift) & MASK_7;
      }
    }
  }

  private static void decode8(ByteBuffer in, long[] intQuads) {
    int idx = 0;
    for (int k = 0; k < 16; ++k) {
      long block0 = in.getLong();
      for (int shift = 8; shift >= 0; shift -= 8) {
        intQuads[idx++] = (block0 >>> shift) & MASK_8;
      }
    }
  }

  private static void decode9(ByteBuffer in, long[] intQuads) {
    int idx = 0;
    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      intQuads[idx++] = (block0 >>> 7) & MASK_9;
      long block1 = in.getLong();
      intQuads[idx++] = ((block0 & MASK_7) << 2) | ((block1 >>> 14) & MASK_2);
      intQuads[idx++] = (block1 >>> 5) & MASK_9;
      long block2 = in.getLong();
      intQuads[idx++] = ((block1 & MASK_5) << 4) | ((block2 >>> 12) & MASK_4);
      intQuads[idx++] = (block2 >>> 3) & MASK_9;
      long block3 = in.getLong();
      intQuads[idx++] = ((block2 & MASK_3) << 6) | ((block3 >>> 10) & MASK_6);
      intQuads[idx++] = (block3 >>> 1) & MASK_9;
      long block4 = in.getLong();
      intQuads[idx++] = ((block3 & MASK_1) << 8) | ((block4 >>> 8) & MASK_8);
      long block5 = in.getLong();
      intQuads[idx++] = ((block4 & MASK_8) << 1) | ((block5 >>> 15) & MASK_1);
      intQuads[idx++] = (block5 >>> 6) & MASK_9;
      long block6 = in.getLong();
      intQuads[idx++] = ((block5 & MASK_6) << 3) | ((block6 >>> 13) & MASK_3);
      intQuads[idx++] = (block6 >>> 4) & MASK_9;
      long block7 = in.getLong();
      intQuads[idx++] = ((block6 & MASK_4) << 5) | ((block7 >>> 11) & MASK_5);
      intQuads[idx++] = (block7 >>> 2) & MASK_9;
      long block8 = in.getLong();
      intQuads[idx++] = ((block7 & MASK_2) << 7) | ((block8 >>> 9) & MASK_7);
      intQuads[idx++] = block8 & MASK_9;
    }
  }

  private static void decode10(ByteBuffer in, long[] intQuads) {
    int idx = 0;
    for (int k = 0; k < 4; ++k) {
      long block0 = in.getLong();
      intQuads[idx++] = (block0 >>> 6) & MASK_10;
      long block1 = in.getLong();
      intQuads[idx++] = ((block0 & MASK_6) << 4) | ((block1 >>> 12) & MASK_4);
      intQuads[idx++] = (block1 >>> 2) & MASK_10;
      long block2 = in.getLong();
      intQuads[idx++] = ((block1 & MASK_2) << 8) | ((block2 >>> 8) & MASK_8);
      long block3 = in.getLong();
      intQuads[idx++] = ((block2 & MASK_8) << 2) | ((block3 >>> 14) & MASK_2);
      intQuads[idx++] = (block3 >>> 4) & MASK_10;
      long block4 = in.getLong();
      intQuads[idx++] = ((block3 & MASK_4) << 6) | ((block4 >>> 10) & MASK_6);
      intQuads[idx++] = block4 & MASK_10;
    }
  }

  private static void decode11(ByteBuffer in, long[] intQuads) {
    int idx = 0;
    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      intQuads[idx++] = (block0 >>> 5) & MASK_11;
      long block1 = in.getLong();
      intQuads[idx++] = ((block0 & MASK_5) << 6) | ((block1 >>> 10) & MASK_6);
      long block2 = in.getLong();
      intQuads[idx++] = ((block1 & MASK_10) << 1) | ((block2 >>> 15) & MASK_1);
      intQuads[idx++] = (block2 >>> 4) & MASK_11;
      long block3 = in.getLong();
      intQuads[idx++] = ((block2 & MASK_4) << 7) | ((block3 >>> 9) & MASK_7);
      long block4 = in.getLong();
      intQuads[idx++] = ((block3 & MASK_9) << 2) | ((block4 >>> 14) & MASK_2);
      intQuads[idx++] = (block4 >>> 3) & MASK_11;
      long block5 = in.getLong();
      intQuads[idx++] = ((block4 & MASK_3) << 8) | ((block5 >>> 8) & MASK_8);
      long block6 = in.getLong();
      intQuads[idx++] = ((block5 & MASK_8) << 3) | ((block6 >>> 13) & MASK_3);
      intQuads[idx++] = (block6 >>> 2) & MASK_11;
      long block7 = in.getLong();
      intQuads[idx++] = ((block6 & MASK_2) << 9) | ((block7 >>> 7) & MASK_9);
      long block8 = in.getLong();
      intQuads[idx++] = ((block7 & MASK_7) << 4) | ((block8 >>> 12) & MASK_4);
      intQuads[idx++] = (block8 >>> 1) & MASK_11;
      long block9 = in.getLong();
      intQuads[idx++] = ((block8 & MASK_1) << 10) | ((block9 >>> 6) & MASK_10);
      long block10 = in.getLong();
      intQuads[idx++] = ((block9 & MASK_6) << 5) | ((block10 >>> 11) & MASK_5);
      intQuads[idx++] = block10 & MASK_11;
    }
  }

  private static void decode12(ByteBuffer in, long[] intQuads) {
    int idx = 0;
    for (int k = 0; k < 8; ++k) {
      long block0 = in.getLong();
      intQuads[idx++] = (block0 >>> 4) & MASK_12;
      long block1 = in.getLong();
      intQuads[idx++] = ((block0 & MASK_4) << 8) | ((block1 >>> 8) & MASK_8);
      long block2 = in.getLong();
      intQuads[idx++] = ((block1 & MASK_8) << 4) | ((block2 >>> 12) & MASK_4);
      intQuads[idx++] = block2 & MASK_12;
    }
  }

  private static void decode13(ByteBuffer in, long[] intQuads) {
    int idx = 0;
    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      intQuads[idx++] = (block0 >>> 3) & MASK_13;
      long block1 = in.getLong();
      intQuads[idx++] = ((block0 & MASK_3) << 10) | ((block1 >>> 6) & MASK_10);
      long block2 = in.getLong();
      intQuads[idx++] = ((block1 & MASK_6) << 7) | ((block2 >>> 9) & MASK_7);
      long block3 = in.getLong();
      intQuads[idx++] = ((block2 & MASK_9) << 4) | ((block3 >>> 12) & MASK_4);
      long block4 = in.getLong();
      intQuads[idx++] = ((block3 & MASK_12) << 1) | ((block4 >>> 15) & MASK_1);
      intQuads[idx++] = (block4 >>> 2) & MASK_13;
      long block5 = in.getLong();
      intQuads[idx++] = ((block4 & MASK_2) << 11) | ((block5 >>> 5) & MASK_11);
      long block6 = in.getLong();
      intQuads[idx++] = ((block5 & MASK_5) << 8) | ((block6 >>> 8) & MASK_8);
      long block7 = in.getLong();
      intQuads[idx++] = ((block6 & MASK_8) << 5) | ((block7 >>> 11) & MASK_5);
      long block8 = in.getLong();
      intQuads[idx++] = ((block7 & MASK_11) << 2) | ((block8 >>> 14) & MASK_2);
      intQuads[idx++] = (block8 >>> 1) & MASK_13;
      long block9 = in.getLong();
      intQuads[idx++] = ((block8 & MASK_1) << 12) | ((block9 >>> 4) & MASK_12);
      long block10 = in.getLong();
      intQuads[idx++] = ((block9 & MASK_4) << 9) | ((block10 >>> 7) & MASK_9);
      long block11 = in.getLong();
      intQuads[idx++] = ((block10 & MASK_7) << 6) | ((block11 >>> 10) & MASK_6);
      long block12 = in.getLong();
      intQuads[idx++] = ((block11 & MASK_10) << 3) | ((block12 >>> 13) & MASK_3);
      intQuads[idx++] = block12 & MASK_13;
    }
  }

  private static void decode14(ByteBuffer in, long[] intQuads) {
    int idx = 0;
    for (int k = 0; k < 4; ++k) {
      long block0 = in.getLong();
      intQuads[idx++] = (block0 >>> 2) & MASK_14;
      long block1 = in.getLong();
      intQuads[idx++] = ((block0 & MASK_2) << 12) | ((block1 >>> 4) & MASK_12);
      long block2 = in.getLong();
      intQuads[idx++] = ((block1 & MASK_4) << 10) | ((block2 >>> 6) & MASK_10);
      long block3 = in.getLong();
      intQuads[idx++] = ((block2 & MASK_6) << 8) | ((block3 >>> 8) & MASK_8);
      long block4 = in.getLong();
      intQuads[idx++] = ((block3 & MASK_8) << 6) | ((block4 >>> 10) & MASK_6);
      long block5 = in.getLong();
      intQuads[idx++] = ((block4 & MASK_10) << 4) | ((block5 >>> 12) & MASK_4);
      long block6 = in.getLong();
      intQuads[idx++] = ((block5 & MASK_12) << 2) | ((block6 >>> 14) & MASK_2);
      intQuads[idx++] = block6 & MASK_14;
    }
  }

  private static void decode15(ByteBuffer in, long[] intQuads) {
    int idx = 0;
    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      intQuads[idx++] = (block0 >>> 1) & MASK_15;
      long block1 = in.getLong();
      intQuads[idx++] = ((block0 & MASK_1) << 14) | ((block1 >>> 2) & MASK_14);
      long block2 = in.getLong();
      intQuads[idx++] = ((block1 & MASK_2) << 13) | ((block2 >>> 3) & MASK_13);
      long block3 = in.getLong();
      intQuads[idx++] = ((block2 & MASK_3) << 12) | ((block3 >>> 4) & MASK_12);
      long block4 = in.getLong();
      intQuads[idx++] = ((block3 & MASK_4) << 11) | ((block4 >>> 5) & MASK_11);
      long block5 = in.getLong();
      intQuads[idx++] = ((block4 & MASK_5) << 10) | ((block5 >>> 6) & MASK_10);
      long block6 = in.getLong();
      intQuads[idx++] = ((block5 & MASK_6) << 9) | ((block6 >>> 7) & MASK_9);
      long block7 = in.getLong();
      intQuads[idx++] = ((block6 & MASK_7) << 8) | ((block7 >>> 8) & MASK_8);
      long block8 = in.getLong();
      intQuads[idx++] = ((block7 & MASK_8) << 7) | ((block8 >>> 9) & MASK_7);
      long block9 = in.getLong();
      intQuads[idx++] = ((block8 & MASK_9) << 6) | ((block9 >>> 10) & MASK_6);
      long block10 = in.getLong();
      intQuads[idx++] = ((block9 & MASK_10) << 5) | ((block10 >>> 11) & MASK_5);
      long block11 = in.getLong();
      intQuads[idx++] = ((block10 & MASK_11) << 4) | ((block11 >>> 12) & MASK_4);
      long block12 = in.getLong();
      intQuads[idx++] = ((block11 & MASK_12) << 3) | ((block12 >>> 13) & MASK_3);
      long block13 = in.getLong();
      intQuads[idx++] = ((block12 & MASK_13) << 2) | ((block13 >>> 14) & MASK_2);
      long block14 = in.getLong();
      intQuads[idx++] = ((block13 & MASK_14) << 1) | ((block14 >>> 15) & MASK_1);
      intQuads[idx++] = block14 & MASK_15;
    }
  }

  private static void decode16(ByteBuffer in, long[] intQuads) {
    int idx = 0;
    for (int k = 0; k < 32; ++k) {
      long block0 = in.getLong();
      intQuads[idx++] = block0 & MASK_16;
    }
  }

}
