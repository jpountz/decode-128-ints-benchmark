package jpountz;

import java.nio.ByteBuffer;

/**
 * Naive decoding of packed longs that reads longs.
 */
public class NaiveLongDecoder {

  private static long mask(int bitsPerValue) {
    return (1L << bitsPerValue) - 1;
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

  private static void decode1(ByteBuffer in, long[] longs) {
    int idx = 0;
    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 63; shift >= 0; shift -= 1) {
        longs[idx++] = (block0 >>> shift) & MASK_1;
      }
    }
  }

  private static void decode2(ByteBuffer in, long[] longs) {
    int idx = 0;
    for (int k = 0; k < 4; ++k) {
      long block0 = in.getLong();
      for (int shift = 62; shift >= 0; shift -= 2) {
        longs[idx++] = (block0 >>> shift) & MASK_2;
      }
    }
  }

  private static void decode3(ByteBuffer in, long[] longs) {
    int idx = 0;
    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 61; shift >= 0; shift -= 3) {
        longs[idx++] = (block0 >>> shift) & MASK_3;
      }
      long block1 = in.getLong();
      longs[idx++] = ((block0 & MASK_1) << 2) | (block1 >>> 62);
      for (int shift = 59; shift >= 0; shift -= 3) {
        longs[idx++] = (block1 >>> shift) & MASK_3;
      }
      long block2 = in.getLong();
      longs[idx++] = ((block1 & MASK_2) << 1) | (block2 >>> 63);
      for (int shift = 60; shift >= 0; shift -= 3) {
        longs[idx++] = (block2 >>> shift) & MASK_3;
      }
    }
  }

  private static void decode4(ByteBuffer in, long[] longs) {
    int idx = 0;
    for (int k = 0; k < 8; ++k) {
      long block0 = in.getLong();
      for (int shift = 60; shift >= 0; shift -= 4) {
        longs[idx++] = (block0 >>> shift) & MASK_4;
      }
    }
  }

  private static void decode5(ByteBuffer in, long[] longs) {
    int idx = 0;
    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 59; shift >= 0; shift -= 5) {
        longs[idx++] = (block0 >>> shift) & MASK_5;
      }
      long block1 = in.getLong();
      longs[idx++] = ((block0 & MASK_4) << 1) | (block1 >>> 63);
      for (int shift = 58; shift >= 0; shift -= 5) {
        longs[idx++] = (block1 >>> shift) & MASK_5;
      }
      long block2 = in.getLong();
      longs[idx++] = ((block1 & MASK_3) << 2) | (block2 >>> 62);
      for (int shift = 57; shift >= 0; shift -= 5) {
        longs[idx++] = (block2 >>> shift) & MASK_5;
      }
      long block3 = in.getLong();
      longs[idx++] = ((block2 & MASK_2) << 3) | (block3 >>> 61);
      for (int shift = 56; shift >= 0; shift -= 5) {
        longs[idx++] = (block3 >>> shift) & MASK_5;
      }
      long block4 = in.getLong();
      longs[idx++] = ((block3 & MASK_1) << 4) | (block4 >>> 60);
      for (int shift = 55; shift >= 0; shift -= 5) {
        longs[idx++] = (block4 >>> shift) & MASK_5;
      }
    }
  }

  private static void decode6(ByteBuffer in, long[] longs) {
    int idx = 0;
    for (int k = 0; k < 4; ++k) {
      long block0 = in.getLong();
      for (int shift = 58; shift >= 0; shift -= 6) {
        longs[idx++] = (block0 >>> shift) & MASK_6;
      }
      long block1 = in.getLong();
      longs[idx++] = ((block0 & MASK_4) << 2) | (block1 >>> 62);
      for (int shift = 56; shift >= 0; shift -= 6) {
        longs[idx++] = (block1 >>> shift) & MASK_6;
      }
      long block2 = in.getLong();
      longs[idx++] = ((block1 & MASK_2) << 4) | (block2 >>> 60);
      for (int shift = 54; shift >= 0; shift -= 6) {
        longs[idx++] = (block2 >>> shift) & MASK_6;
      }
    }
  }

  private static void decode7(ByteBuffer in, long[] longs) {
    int idx = 0;
    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 57; shift >= 0; shift -= 7) {
        longs[idx++] = (block0 >>> shift) & MASK_7;
      }
      long block1 = in.getLong();
      longs[idx++] = ((block0 & MASK_1) << 6) | (block1 >>> 58);
      for (int shift = 51; shift >= 0; shift -= 7) {
        longs[idx++] = (block1 >>> shift) & MASK_7;
      }
      long block2 = in.getLong();
      longs[idx++] = ((block1 & MASK_2) << 5) | (block2 >>> 59);
      for (int shift = 52; shift >= 0; shift -= 7) {
        longs[idx++] = (block2 >>> shift) & MASK_7;
      }
      long block3 = in.getLong();
      longs[idx++] = ((block2 & MASK_3) << 4) | (block3 >>> 60);
      for (int shift = 53; shift >= 0; shift -= 7) {
        longs[idx++] = (block3 >>> shift) & MASK_7;
      }
      long block4 = in.getLong();
      longs[idx++] = ((block3 & MASK_4) << 3) | (block4 >>> 61);
      for (int shift = 54; shift >= 0; shift -= 7) {
        longs[idx++] = (block4 >>> shift) & MASK_7;
      }
      long block5 = in.getLong();
      longs[idx++] = ((block4 & MASK_5) << 2) | (block5 >>> 62);
      for (int shift = 55; shift >= 0; shift -= 7) {
        longs[idx++] = (block5 >>> shift) & MASK_7;
      }
      long block6 = in.getLong();
      longs[idx++] = ((block5 & MASK_6) << 1) | (block6 >>> 63);
      for (int shift = 56; shift >= 0; shift -= 7) {
        longs[idx++] = (block6 >>> shift) & MASK_7;
      }
    }
  }

  private static void decode8(ByteBuffer in, long[] longs) {
    int idx = 0;
    for (int k = 0; k < 16; ++k) {
      long block0 = in.getLong();
      for (int shift = 56; shift >= 0; shift -= 8) {
        longs[idx++] = (block0 >>> shift) & MASK_8;
      }
    }
  }

  private static void decode9(ByteBuffer in, long[] longs) {
    int idx = 0;
    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 55; shift >= 0; shift -= 9) {
        longs[idx++] = (block0 >>> shift) & MASK_9;
      }
      long block1 = in.getLong();
      longs[idx++] = ((block0 & MASK_1) << 8) | (block1 >>> 56);
      for (int shift = 47; shift >= 0; shift -= 9) {
        longs[idx++] = (block1 >>> shift) & MASK_9;
      }
      long block2 = in.getLong();
      longs[idx++] = ((block1 & MASK_2) << 7) | (block2 >>> 57);
      for (int shift = 48; shift >= 0; shift -= 9) {
        longs[idx++] = (block2 >>> shift) & MASK_9;
      }
      long block3 = in.getLong();
      longs[idx++] = ((block2 & MASK_3) << 6) | (block3 >>> 58);
      for (int shift = 49; shift >= 0; shift -= 9) {
        longs[idx++] = (block3 >>> shift) & MASK_9;
      }
      long block4 = in.getLong();
      longs[idx++] = ((block3 & MASK_4) << 5) | (block4 >>> 59);
      for (int shift = 50; shift >= 0; shift -= 9) {
        longs[idx++] = (block4 >>> shift) & MASK_9;
      }
      long block5 = in.getLong();
      longs[idx++] = ((block4 & MASK_5) << 4) | (block5 >>> 60);
      for (int shift = 51; shift >= 0; shift -= 9) {
        longs[idx++] = (block5 >>> shift) & MASK_9;
      }
      long block6 = in.getLong();
      longs[idx++] = ((block5 & MASK_6) << 3) | (block6 >>> 61);
      for (int shift = 52; shift >= 0; shift -= 9) {
        longs[idx++] = (block6 >>> shift) & MASK_9;
      }
      long block7 = in.getLong();
      longs[idx++] = ((block6 & MASK_7) << 2) | (block7 >>> 62);
      for (int shift = 53; shift >= 0; shift -= 9) {
        longs[idx++] = (block7 >>> shift) & MASK_9;
      }
      long block8 = in.getLong();
      longs[idx++] = ((block7 & MASK_8) << 1) | (block8 >>> 63);
      for (int shift = 54; shift >= 0; shift -= 9) {
        longs[idx++] = (block8 >>> shift) & MASK_9;
      }
    }
  }

  private static void decode10(ByteBuffer in, long[] longs) {
    int idx = 0;
    for (int k = 0; k < 4; ++k) {
      long block0 = in.getLong();
      for (int shift = 54; shift >= 0; shift -= 10) {
        longs[idx++] = (block0 >>> shift) & MASK_10;
      }
      long block1 = in.getLong();
      longs[idx++] = ((block0 & MASK_4) << 6) | (block1 >>> 58);
      for (int shift = 48; shift >= 0; shift -= 10) {
        longs[idx++] = (block1 >>> shift) & MASK_10;
      }
      long block2 = in.getLong();
      longs[idx++] = ((block1 & MASK_8) << 2) | (block2 >>> 62);
      for (int shift = 52; shift >= 0; shift -= 10) {
        longs[idx++] = (block2 >>> shift) & MASK_10;
      }
      long block3 = in.getLong();
      longs[idx++] = ((block2 & MASK_2) << 8) | (block3 >>> 56);
      for (int shift = 46; shift >= 0; shift -= 10) {
        longs[idx++] = (block3 >>> shift) & MASK_10;
      }
      long block4 = in.getLong();
      longs[idx++] = ((block3 & MASK_6) << 4) | (block4 >>> 60);
      for (int shift = 50; shift >= 0; shift -= 10) {
        longs[idx++] = (block4 >>> shift) & MASK_10;
      }
    }
  }

  private static void decode11(ByteBuffer in, long[] longs) {
    int idx = 0;
    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 53; shift >= 0; shift -= 11) {
        longs[idx++] = (block0 >>> shift) & MASK_11;
      }
      long block1 = in.getLong();
      longs[idx++] = ((block0 & MASK_9) << 2) | (block1 >>> 62);
      for (int shift = 51; shift >= 0; shift -= 11) {
        longs[idx++] = (block1 >>> shift) & MASK_11;
      }
      long block2 = in.getLong();
      longs[idx++] = ((block1 & MASK_7) << 4) | (block2 >>> 60);
      for (int shift = 49; shift >= 0; shift -= 11) {
        longs[idx++] = (block2 >>> shift) & MASK_11;
      }
      long block3 = in.getLong();
      longs[idx++] = ((block2 & MASK_5) << 6) | (block3 >>> 58);
      for (int shift = 47; shift >= 0; shift -= 11) {
        longs[idx++] = (block3 >>> shift) & MASK_11;
      }
      long block4 = in.getLong();
      longs[idx++] = ((block3 & MASK_3) << 8) | (block4 >>> 56);
      for (int shift = 45; shift >= 0; shift -= 11) {
        longs[idx++] = (block4 >>> shift) & MASK_11;
      }
      long block5 = in.getLong();
      longs[idx++] = ((block4 & MASK_1) << 10) | (block5 >>> 54);
      for (int shift = 43; shift >= 0; shift -= 11) {
        longs[idx++] = (block5 >>> shift) & MASK_11;
      }
      long block6 = in.getLong();
      longs[idx++] = ((block5 & MASK_10) << 1) | (block6 >>> 63);
      for (int shift = 52; shift >= 0; shift -= 11) {
        longs[idx++] = (block6 >>> shift) & MASK_11;
      }
      long block7 = in.getLong();
      longs[idx++] = ((block6 & MASK_8) << 3) | (block7 >>> 61);
      for (int shift = 50; shift >= 0; shift -= 11) {
        longs[idx++] = (block7 >>> shift) & MASK_11;
      }
      long block8 = in.getLong();
      longs[idx++] = ((block7 & MASK_6) << 5) | (block8 >>> 59);
      for (int shift = 48; shift >= 0; shift -= 11) {
        longs[idx++] = (block8 >>> shift) & MASK_11;
      }
      long block9 = in.getLong();
      longs[idx++] = ((block8 & MASK_4) << 7) | (block9 >>> 57);
      for (int shift = 46; shift >= 0; shift -= 11) {
        longs[idx++] = (block9 >>> shift) & MASK_11;
      }
      long block10 = in.getLong();
      longs[idx++] = ((block9 & MASK_2) << 9) | (block10 >>> 55);
      for (int shift = 44; shift >= 0; shift -= 11) {
        longs[idx++] = (block10 >>> shift) & MASK_11;
      }
    }
  }

  private static void decode12(ByteBuffer in, long[] longs) {
    int idx = 0;
    for (int k = 0; k < 8; ++k) {
      long block0 = in.getLong();
      for (int shift = 52; shift >= 0; shift -= 12) {
        longs[idx++] = (block0 >>> shift) & MASK_12;
      }
      long block1 = in.getLong();
      longs[idx++] = ((block0 & MASK_4) << 8) | (block1 >>> 56);
      for (int shift = 44; shift >= 0; shift -= 12) {
        longs[idx++] = (block1 >>> shift) & MASK_12;
      }
      long block2 = in.getLong();
      longs[idx++] = ((block1 & MASK_8) << 4) | (block2 >>> 60);
      for (int shift = 48; shift >= 0; shift -= 12) {
        longs[idx++] = (block2 >>> shift) & MASK_12;
      }
    }
  }

  private static void decode13(ByteBuffer in, long[] longs) {
    int idx = 0;
    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 51; shift >= 0; shift -= 13) {
        longs[idx++] = (block0 >>> shift) & MASK_13;
      }
      long block1 = in.getLong();
      longs[idx++] = ((block0 & MASK_12) << 1) | (block1 >>> 63);
      for (int shift = 50; shift >= 0; shift -= 13) {
        longs[idx++] = (block1 >>> shift) & MASK_13;
      }
      long block2 = in.getLong();
      longs[idx++] = ((block1 & MASK_11) << 2) | (block2 >>> 62);
      for (int shift = 49; shift >= 0; shift -= 13) {
        longs[idx++] = (block2 >>> shift) & MASK_13;
      }
      long block3 = in.getLong();
      longs[idx++] = ((block2 & MASK_10) << 3) | (block3 >>> 61);
      for (int shift = 48; shift >= 0; shift -= 13) {
        longs[idx++] = (block3 >>> shift) & MASK_13;
      }
      long block4 = in.getLong();
      longs[idx++] = ((block3 & MASK_9) << 4) | (block4 >>> 60);
      for (int shift = 47; shift >= 0; shift -= 13) {
        longs[idx++] = (block4 >>> shift) & MASK_13;
      }
      long block5 = in.getLong();
      longs[idx++] = ((block4 & MASK_8) << 5) | (block5 >>> 59);
      for (int shift = 46; shift >= 0; shift -= 13) {
        longs[idx++] = (block5 >>> shift) & MASK_13;
      }
      long block6 = in.getLong();
      longs[idx++] = ((block5 & MASK_7) << 6) | (block6 >>> 58);
      for (int shift = 45; shift >= 0; shift -= 13) {
        longs[idx++] = (block6 >>> shift) & MASK_13;
      }
      long block7 = in.getLong();
      longs[idx++] = ((block6 & MASK_6) << 7) | (block7 >>> 57);
      for (int shift = 44; shift >= 0; shift -= 13) {
        longs[idx++] = (block7 >>> shift) & MASK_13;
      }
      long block8 = in.getLong();
      longs[idx++] = ((block7 & MASK_5) << 8) | (block8 >>> 56);
      for (int shift = 43; shift >= 0; shift -= 13) {
        longs[idx++] = (block8 >>> shift) & MASK_13;
      }
      long block9 = in.getLong();
      longs[idx++] = ((block8 & MASK_4) << 9) | (block9 >>> 55);
      for (int shift = 42; shift >= 0; shift -= 13) {
        longs[idx++] = (block9 >>> shift) & MASK_13;
      }
      long block10 = in.getLong();
      longs[idx++] = ((block9 & MASK_3) << 10) | (block10 >>> 54);
      for (int shift = 41; shift >= 0; shift -= 13) {
        longs[idx++] = (block10 >>> shift) & MASK_13;
      }
      long block11 = in.getLong();
      longs[idx++] = ((block10 & MASK_2) << 11) | (block11 >>> 53);
      for (int shift = 40; shift >= 0; shift -= 13) {
        longs[idx++] = (block11 >>> shift) & MASK_13;
      }
      long block12 = in.getLong();
      longs[idx++] = ((block11 & MASK_1) << 12) | (block12 >>> 52);
      for (int shift = 39; shift >= 0; shift -= 13) {
        longs[idx++] = (block12 >>> shift) & MASK_13;
      }
    }
  }

  private static void decode14(ByteBuffer in, long[] longs) {
    int idx = 0;
    for (int k = 0; k < 4; ++k) {
      long block0 = in.getLong();
      for (int shift = 50; shift >= 0; shift -= 14) {
        longs[idx++] = (block0 >>> shift) & MASK_14;
      }
      long block1 = in.getLong();
      longs[idx++] = ((block0 & MASK_8) << 6) | (block1 >>> 58);
      for (int shift = 44; shift >= 0; shift -= 14) {
        longs[idx++] = (block1 >>> shift) & MASK_14;
      }
      long block2 = in.getLong();
      longs[idx++] = ((block1 & MASK_2) << 12) | (block2 >>> 52);
      for (int shift = 38; shift >= 0; shift -= 14) {
        longs[idx++] = (block2 >>> shift) & MASK_14;
      }
      long block3 = in.getLong();
      longs[idx++] = ((block2 & MASK_10) << 4) | (block3 >>> 60);
      for (int shift = 46; shift >= 0; shift -= 14) {
        longs[idx++] = (block3 >>> shift) & MASK_14;
      }
      long block4 = in.getLong();
      longs[idx++] = ((block3 & MASK_4) << 10) | (block4 >>> 54);
      for (int shift = 40; shift >= 0; shift -= 14) {
        longs[idx++] = (block4 >>> shift) & MASK_14;
      }
      long block5 = in.getLong();
      longs[idx++] = ((block4 & MASK_12) << 2) | (block5 >>> 62);
      for (int shift = 48; shift >= 0; shift -= 14) {
        longs[idx++] = (block5 >>> shift) & MASK_14;
      }
      long block6 = in.getLong();
      longs[idx++] = ((block5 & MASK_6) << 8) | (block6 >>> 56);
      for (int shift = 42; shift >= 0; shift -= 14) {
        longs[idx++] = (block6 >>> shift) & MASK_14;
      }
    }
  }

  private static void decode15(ByteBuffer in, long[] longs) {
    int idx = 0;
    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 49; shift >= 0; shift -= 15) {
        longs[idx++] = (block0 >>> shift) & MASK_15;
      }
      long block1 = in.getLong();
      longs[idx++] = ((block0 & MASK_4) << 11) | (block1 >>> 53);
      for (int shift = 38; shift >= 0; shift -= 15) {
        longs[idx++] = (block1 >>> shift) & MASK_15;
      }
      long block2 = in.getLong();
      longs[idx++] = ((block1 & MASK_8) << 7) | (block2 >>> 57);
      for (int shift = 42; shift >= 0; shift -= 15) {
        longs[idx++] = (block2 >>> shift) & MASK_15;
      }
      long block3 = in.getLong();
      longs[idx++] = ((block2 & MASK_12) << 3) | (block3 >>> 61);
      for (int shift = 46; shift >= 0; shift -= 15) {
        longs[idx++] = (block3 >>> shift) & MASK_15;
      }
      long block4 = in.getLong();
      longs[idx++] = ((block3 & MASK_1) << 14) | (block4 >>> 50);
      for (int shift = 35; shift >= 0; shift -= 15) {
        longs[idx++] = (block4 >>> shift) & MASK_15;
      }
      long block5 = in.getLong();
      longs[idx++] = ((block4 & MASK_5) << 10) | (block5 >>> 54);
      for (int shift = 39; shift >= 0; shift -= 15) {
        longs[idx++] = (block5 >>> shift) & MASK_15;
      }
      long block6 = in.getLong();
      longs[idx++] = ((block5 & MASK_9) << 6) | (block6 >>> 58);
      for (int shift = 43; shift >= 0; shift -= 15) {
        longs[idx++] = (block6 >>> shift) & MASK_15;
      }
      long block7 = in.getLong();
      longs[idx++] = ((block6 & MASK_13) << 2) | (block7 >>> 62);
      for (int shift = 47; shift >= 0; shift -= 15) {
        longs[idx++] = (block7 >>> shift) & MASK_15;
      }
      long block8 = in.getLong();
      longs[idx++] = ((block7 & MASK_2) << 13) | (block8 >>> 51);
      for (int shift = 36; shift >= 0; shift -= 15) {
        longs[idx++] = (block8 >>> shift) & MASK_15;
      }
      long block9 = in.getLong();
      longs[idx++] = ((block8 & MASK_6) << 9) | (block9 >>> 55);
      for (int shift = 40; shift >= 0; shift -= 15) {
        longs[idx++] = (block9 >>> shift) & MASK_15;
      }
      long block10 = in.getLong();
      longs[idx++] = ((block9 & MASK_10) << 5) | (block10 >>> 59);
      for (int shift = 44; shift >= 0; shift -= 15) {
        longs[idx++] = (block10 >>> shift) & MASK_15;
      }
      long block11 = in.getLong();
      longs[idx++] = ((block10 & MASK_14) << 1) | (block11 >>> 63);
      for (int shift = 48; shift >= 0; shift -= 15) {
        longs[idx++] = (block11 >>> shift) & MASK_15;
      }
      long block12 = in.getLong();
      longs[idx++] = ((block11 & MASK_3) << 12) | (block12 >>> 52);
      for (int shift = 37; shift >= 0; shift -= 15) {
        longs[idx++] = (block12 >>> shift) & MASK_15;
      }
      long block13 = in.getLong();
      longs[idx++] = ((block12 & MASK_7) << 8) | (block13 >>> 56);
      for (int shift = 41; shift >= 0; shift -= 15) {
        longs[idx++] = (block13 >>> shift) & MASK_15;
      }
      long block14 = in.getLong();
      longs[idx++] = ((block13 & MASK_11) << 4) | (block14 >>> 60);
      for (int shift = 45; shift >= 0; shift -= 15) {
        longs[idx++] = (block14 >>> shift) & MASK_15;
      }
    }
  }

  private static void decode16(ByteBuffer in, long[] longs) {
    int idx = 0;
    for (int k = 0; k < 32; ++k) {
      long block0 = in.getLong();
      for (int shift = 48; shift >= 0; shift -= 16) {
        longs[idx++] = (block0 >>> shift) & MASK_16;
      }
    }
  }

}
