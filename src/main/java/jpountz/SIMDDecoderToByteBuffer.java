package jpountz;

import java.nio.ByteBuffer;

public class SIMDDecoderToByteBuffer {

  private static long expandMask(long mask32) {
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

  static void decode(int bitsPerValue, ByteBuffer in, ByteBuffer longs) {
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

  private static void decode1(ByteBuffer in, ByteBuffer intPairs) {

    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 31; shift >= 0; shift -= 1) {
        intPairs.putLong((block0 >>> shift) & MASK_1);
      }
    }
  }

  private static void decode2(ByteBuffer in, ByteBuffer intPairs) {

    for (int k = 0; k < 4; ++k) {
      long block0 = in.getLong();
      for (int shift = 30; shift >= 0; shift -= 2) {
        intPairs.putLong((block0 >>> shift) & MASK_2);
      }
    }
  }

  private static void decode3(ByteBuffer in, ByteBuffer intPairs) {

    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 29; shift >= 0; shift -= 3) {
        intPairs.putLong((block0 >>> shift) & MASK_3);
      }
      long block1 = in.getLong();
      intPairs.putLong(((block0 & MASK_2) << 1) | ((block1 >>> 31) & MASK_1));
      for (int shift = 28; shift >= 0; shift -= 3) {
        intPairs.putLong((block1 >>> shift) & MASK_3);
      }
      long block2 = in.getLong();
      intPairs.putLong(((block1 & MASK_1) << 2) | ((block2 >>> 30) & MASK_2));
      for (int shift = 27; shift >= 0; shift -= 3) {
        intPairs.putLong((block2 >>> shift) & MASK_3);
      }
    }
  }

  private static void decode4(ByteBuffer in, ByteBuffer intPairs) {

    for (int k = 0; k < 8; ++k) {
      long block0 = in.getLong();
      for (int shift = 28; shift >= 0; shift -= 4) {
        intPairs.putLong((block0 >>> shift) & MASK_4);
      }
    }
  }

  private static void decode5(ByteBuffer in, ByteBuffer intPairs) {

    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 27; shift >= 0; shift -= 5) {
        intPairs.putLong((block0 >>> shift) & MASK_5);
      }
      long block1 = in.getLong();
      intPairs.putLong(((block0 & MASK_2) << 3) | ((block1 >>> 29) & MASK_3));
      for (int shift = 24; shift >= 0; shift -= 5) {
        intPairs.putLong((block1 >>> shift) & MASK_5);
      }
      long block2 = in.getLong();
      intPairs.putLong(((block1 & MASK_4) << 1) | ((block2 >>> 31) & MASK_1));
      for (int shift = 26; shift >= 0; shift -= 5) {
        intPairs.putLong((block2 >>> shift) & MASK_5);
      }
      long block3 = in.getLong();
      intPairs.putLong(((block2 & MASK_1) << 4) | ((block3 >>> 28) & MASK_4));
      for (int shift = 23; shift >= 0; shift -= 5) {
        intPairs.putLong((block3 >>> shift) & MASK_5);
      }
      long block4 = in.getLong();
      intPairs.putLong(((block3 & MASK_3) << 2) | ((block4 >>> 30) & MASK_2));
      for (int shift = 25; shift >= 0; shift -= 5) {
        intPairs.putLong((block4 >>> shift) & MASK_5);
      }
    }
  }

  private static void decode6(ByteBuffer in, ByteBuffer intPairs) {

    for (int k = 0; k < 4; ++k) {
      long block0 = in.getLong();
      for (int shift = 26; shift >= 0; shift -= 6) {
        intPairs.putLong((block0 >>> shift) & MASK_6);
      }
      long block1 = in.getLong();
      intPairs.putLong(((block0 & MASK_2) << 4) | ((block1 >>> 28) & MASK_4));
      for (int shift = 22; shift >= 0; shift -= 6) {
        intPairs.putLong((block1 >>> shift) & MASK_6);
      }
      long block2 = in.getLong();
      intPairs.putLong(((block1 & MASK_4) << 2) | ((block2 >>> 30) & MASK_2));
      for (int shift = 24; shift >= 0; shift -= 6) {
        intPairs.putLong((block2 >>> shift) & MASK_6);
      }
    }
  }

  private static void decode7(ByteBuffer in, ByteBuffer intPairs) {

    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 25; shift >= 0; shift -= 7) {
        intPairs.putLong((block0 >>> shift) & MASK_7);
      }
      long block1 = in.getLong();
      intPairs.putLong(((block0 & MASK_4) << 3) | ((block1 >>> 29) & MASK_3));
      for (int shift = 22; shift >= 0; shift -= 7) {
        intPairs.putLong((block1 >>> shift) & MASK_7);
      }
      long block2 = in.getLong();
      intPairs.putLong(((block1 & MASK_1) << 6) | ((block2 >>> 26) & MASK_6));
      for (int shift = 19; shift >= 0; shift -= 7) {
        intPairs.putLong((block2 >>> shift) & MASK_7);
      }
      long block3 = in.getLong();
      intPairs.putLong(((block2 & MASK_5) << 2) | ((block3 >>> 30) & MASK_2));
      for (int shift = 23; shift >= 0; shift -= 7) {
        intPairs.putLong((block3 >>> shift) & MASK_7);
      }
      long block4 = in.getLong();
      intPairs.putLong(((block3 & MASK_2) << 5) | ((block4 >>> 27) & MASK_5));
      for (int shift = 20; shift >= 0; shift -= 7) {
        intPairs.putLong((block4 >>> shift) & MASK_7);
      }
      long block5 = in.getLong();
      intPairs.putLong(((block4 & MASK_6) << 1) | ((block5 >>> 31) & MASK_1));
      for (int shift = 24; shift >= 0; shift -= 7) {
        intPairs.putLong((block5 >>> shift) & MASK_7);
      }
      long block6 = in.getLong();
      intPairs.putLong(((block5 & MASK_3) << 4) | ((block6 >>> 28) & MASK_4));
      for (int shift = 21; shift >= 0; shift -= 7) {
        intPairs.putLong((block6 >>> shift) & MASK_7);
      }
    }
  }

  private static void decode8(ByteBuffer in, ByteBuffer intPairs) {

    for (int k = 0; k < 16; ++k) {
      long block0 = in.getLong();
      for (int shift = 24; shift >= 0; shift -= 8) {
        intPairs.putLong((block0 >>> shift) & MASK_8);
      }
    }
  }

  private static void decode9(ByteBuffer in, ByteBuffer intPairs) {

    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 23; shift >= 0; shift -= 9) {
        intPairs.putLong((block0 >>> shift) & MASK_9);
      }
      long block1 = in.getLong();
      intPairs.putLong(((block0 & MASK_5) << 4) | ((block1 >>> 28) & MASK_4));
      for (int shift = 19; shift >= 0; shift -= 9) {
        intPairs.putLong((block1 >>> shift) & MASK_9);
      }
      long block2 = in.getLong();
      intPairs.putLong(((block1 & MASK_1) << 8) | ((block2 >>> 24) & MASK_8));
      for (int shift = 15; shift >= 0; shift -= 9) {
        intPairs.putLong((block2 >>> shift) & MASK_9);
      }
      long block3 = in.getLong();
      intPairs.putLong(((block2 & MASK_6) << 3) | ((block3 >>> 29) & MASK_3));
      for (int shift = 20; shift >= 0; shift -= 9) {
        intPairs.putLong((block3 >>> shift) & MASK_9);
      }
      long block4 = in.getLong();
      intPairs.putLong(((block3 & MASK_2) << 7) | ((block4 >>> 25) & MASK_7));
      for (int shift = 16; shift >= 0; shift -= 9) {
        intPairs.putLong((block4 >>> shift) & MASK_9);
      }
      long block5 = in.getLong();
      intPairs.putLong(((block4 & MASK_7) << 2) | ((block5 >>> 30) & MASK_2));
      for (int shift = 21; shift >= 0; shift -= 9) {
        intPairs.putLong((block5 >>> shift) & MASK_9);
      }
      long block6 = in.getLong();
      intPairs.putLong(((block5 & MASK_3) << 6) | ((block6 >>> 26) & MASK_6));
      for (int shift = 17; shift >= 0; shift -= 9) {
        intPairs.putLong((block6 >>> shift) & MASK_9);
      }
      long block7 = in.getLong();
      intPairs.putLong(((block6 & MASK_8) << 1) | ((block7 >>> 31) & MASK_1));
      for (int shift = 22; shift >= 0; shift -= 9) {
        intPairs.putLong((block7 >>> shift) & MASK_9);
      }
      long block8 = in.getLong();
      intPairs.putLong(((block7 & MASK_4) << 5) | ((block8 >>> 27) & MASK_5));
      for (int shift = 18; shift >= 0; shift -= 9) {
        intPairs.putLong((block8 >>> shift) & MASK_9);
      }
    }
  }

  private static void decode10(ByteBuffer in, ByteBuffer intPairs) {

    for (int k = 0; k < 4; ++k) {
      long block0 = in.getLong();
      for (int shift = 22; shift >= 0; shift -= 10) {
        intPairs.putLong((block0 >>> shift) & MASK_10);
      }
      long block1 = in.getLong();
      intPairs.putLong(((block0 & MASK_2) << 8) | ((block1 >>> 24) & MASK_8));
      for (int shift = 14; shift >= 0; shift -= 10) {
        intPairs.putLong((block1 >>> shift) & MASK_10);
      }
      long block2 = in.getLong();
      intPairs.putLong(((block1 & MASK_4) << 6) | ((block2 >>> 26) & MASK_6));
      for (int shift = 16; shift >= 0; shift -= 10) {
        intPairs.putLong((block2 >>> shift) & MASK_10);
      }
      long block3 = in.getLong();
      intPairs.putLong(((block2 & MASK_6) << 4) | ((block3 >>> 28) & MASK_4));
      for (int shift = 18; shift >= 0; shift -= 10) {
        intPairs.putLong((block3 >>> shift) & MASK_10);
      }
      long block4 = in.getLong();
      intPairs.putLong(((block3 & MASK_8) << 2) | ((block4 >>> 30) & MASK_2));
      for (int shift = 20; shift >= 0; shift -= 10) {
        intPairs.putLong((block4 >>> shift) & MASK_10);
      }
    }
  }

  private static void decode11(ByteBuffer in, ByteBuffer intPairs) {

    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 21; shift >= 0; shift -= 11) {
        intPairs.putLong((block0 >>> shift) & MASK_11);
      }
      long block1 = in.getLong();
      intPairs.putLong(((block0 & MASK_10) << 1) | ((block1 >>> 31) & MASK_1));
      for (int shift = 20; shift >= 0; shift -= 11) {
        intPairs.putLong((block1 >>> shift) & MASK_11);
      }
      long block2 = in.getLong();
      intPairs.putLong(((block1 & MASK_9) << 2) | ((block2 >>> 30) & MASK_2));
      for (int shift = 19; shift >= 0; shift -= 11) {
        intPairs.putLong((block2 >>> shift) & MASK_11);
      }
      long block3 = in.getLong();
      intPairs.putLong(((block2 & MASK_8) << 3) | ((block3 >>> 29) & MASK_3));
      for (int shift = 18; shift >= 0; shift -= 11) {
        intPairs.putLong((block3 >>> shift) & MASK_11);
      }
      long block4 = in.getLong();
      intPairs.putLong(((block3 & MASK_7) << 4) | ((block4 >>> 28) & MASK_4));
      for (int shift = 17; shift >= 0; shift -= 11) {
        intPairs.putLong((block4 >>> shift) & MASK_11);
      }
      long block5 = in.getLong();
      intPairs.putLong(((block4 & MASK_6) << 5) | ((block5 >>> 27) & MASK_5));
      for (int shift = 16; shift >= 0; shift -= 11) {
        intPairs.putLong((block5 >>> shift) & MASK_11);
      }
      long block6 = in.getLong();
      intPairs.putLong(((block5 & MASK_5) << 6) | ((block6 >>> 26) & MASK_6));
      for (int shift = 15; shift >= 0; shift -= 11) {
        intPairs.putLong((block6 >>> shift) & MASK_11);
      }
      long block7 = in.getLong();
      intPairs.putLong(((block6 & MASK_4) << 7) | ((block7 >>> 25) & MASK_7));
      for (int shift = 14; shift >= 0; shift -= 11) {
        intPairs.putLong((block7 >>> shift) & MASK_11);
      }
      long block8 = in.getLong();
      intPairs.putLong(((block7 & MASK_3) << 8) | ((block8 >>> 24) & MASK_8));
      for (int shift = 13; shift >= 0; shift -= 11) {
        intPairs.putLong((block8 >>> shift) & MASK_11);
      }
      long block9 = in.getLong();
      intPairs.putLong(((block8 & MASK_2) << 9) | ((block9 >>> 23) & MASK_9));
      for (int shift = 12; shift >= 0; shift -= 11) {
        intPairs.putLong((block9 >>> shift) & MASK_11);
      }
      long block10 = in.getLong();
      intPairs.putLong(((block9 & MASK_1) << 10) | ((block10 >>> 22) & MASK_10));
      for (int shift = 11; shift >= 0; shift -= 11) {
        intPairs.putLong((block10 >>> shift) & MASK_11);
      }
    }
  }

  private static void decode12(ByteBuffer in, ByteBuffer intPairs) {

    for (int k = 0; k < 8; ++k) {
      long block0 = in.getLong();
      for (int shift = 20; shift >= 0; shift -= 12) {
        intPairs.putLong((block0 >>> shift) & MASK_12);
      }
      long block1 = in.getLong();
      intPairs.putLong(((block0 & MASK_8) << 4) | ((block1 >>> 28) & MASK_4));
      for (int shift = 16; shift >= 0; shift -= 12) {
        intPairs.putLong((block1 >>> shift) & MASK_12);
      }
      long block2 = in.getLong();
      intPairs.putLong(((block1 & MASK_4) << 8) | ((block2 >>> 24) & MASK_8));
      for (int shift = 12; shift >= 0; shift -= 12) {
        intPairs.putLong((block2 >>> shift) & MASK_12);
      }
    }
  }

  private static void decode13(ByteBuffer in, ByteBuffer intPairs) {

    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 19; shift >= 0; shift -= 13) {
        intPairs.putLong((block0 >>> shift) & MASK_13);
      }
      long block1 = in.getLong();
      intPairs.putLong(((block0 & MASK_6) << 7) | ((block1 >>> 25) & MASK_7));
      intPairs.putLong((block1 >>> 12) & MASK_13);
      long block2 = in.getLong();
      intPairs.putLong(((block1 & MASK_12) << 1) | ((block2 >>> 31) & MASK_1));
      for (int shift = 18; shift >= 0; shift -= 13) {
        intPairs.putLong((block2 >>> shift) & MASK_13);
      }
      long block3 = in.getLong();
      intPairs.putLong(((block2 & MASK_5) << 8) | ((block3 >>> 24) & MASK_8));
      intPairs.putLong((block3 >>> 11) & MASK_13);
      long block4 = in.getLong();
      intPairs.putLong(((block3 & MASK_11) << 2) | ((block4 >>> 30) & MASK_2));
      for (int shift = 17; shift >= 0; shift -= 13) {
        intPairs.putLong((block4 >>> shift) & MASK_13);
      }
      long block5 = in.getLong();
      intPairs.putLong(((block4 & MASK_4) << 9) | ((block5 >>> 23) & MASK_9));
      intPairs.putLong((block5 >>> 10) & MASK_13);
      long block6 = in.getLong();
      intPairs.putLong(((block5 & MASK_10) << 3) | ((block6 >>> 29) & MASK_3));
      for (int shift = 16; shift >= 0; shift -= 13) {
        intPairs.putLong((block6 >>> shift) & MASK_13);
      }
      long block7 = in.getLong();
      intPairs.putLong(((block6 & MASK_3) << 10) | ((block7 >>> 22) & MASK_10));
      intPairs.putLong((block7 >>> 9) & MASK_13);
      long block8 = in.getLong();
      intPairs.putLong(((block7 & MASK_9) << 4) | ((block8 >>> 28) & MASK_4));
      for (int shift = 15; shift >= 0; shift -= 13) {
        intPairs.putLong((block8 >>> shift) & MASK_13);
      }
      long block9 = in.getLong();
      intPairs.putLong(((block8 & MASK_2) << 11) | ((block9 >>> 21) & MASK_11));
      intPairs.putLong((block9 >>> 8) & MASK_13);
      long block10 = in.getLong();
      intPairs.putLong(((block9 & MASK_8) << 5) | ((block10 >>> 27) & MASK_5));
      for (int shift = 14; shift >= 0; shift -= 13) {
        intPairs.putLong((block10 >>> shift) & MASK_13);
      }
      long block11 = in.getLong();
      intPairs.putLong(((block10 & MASK_1) << 12) | ((block11 >>> 20) & MASK_12));
      intPairs.putLong((block11 >>> 7) & MASK_13);
      long block12 = in.getLong();
      intPairs.putLong(((block11 & MASK_7) << 6) | ((block12 >>> 26) & MASK_6));
      for (int shift = 13; shift >= 0; shift -= 13) {
        intPairs.putLong((block12 >>> shift) & MASK_13);
      }
    }
  }

  private static void decode14(ByteBuffer in, ByteBuffer intPairs) {

    for (int k = 0; k < 4; ++k) {
      long block0 = in.getLong();
      for (int shift = 18; shift >= 0; shift -= 14) {
        intPairs.putLong((block0 >>> shift) & MASK_14);
      }
      long block1 = in.getLong();
      intPairs.putLong(((block0 & MASK_4) << 10) | ((block1 >>> 22) & MASK_10));
      intPairs.putLong((block1 >>> 8) & MASK_14);
      long block2 = in.getLong();
      intPairs.putLong(((block1 & MASK_8) << 6) | ((block2 >>> 26) & MASK_6));
      intPairs.putLong((block2 >>> 12) & MASK_14);
      long block3 = in.getLong();
      intPairs.putLong(((block2 & MASK_12) << 2) | ((block3 >>> 30) & MASK_2));
      for (int shift = 16; shift >= 0; shift -= 14) {
        intPairs.putLong((block3 >>> shift) & MASK_14);
      }
      long block4 = in.getLong();
      intPairs.putLong(((block3 & MASK_2) << 12) | ((block4 >>> 20) & MASK_12));
      intPairs.putLong((block4 >>> 6) & MASK_14);
      long block5 = in.getLong();
      intPairs.putLong(((block4 & MASK_6) << 8) | ((block5 >>> 24) & MASK_8));
      intPairs.putLong((block5 >>> 10) & MASK_14);
      long block6 = in.getLong();
      intPairs.putLong(((block5 & MASK_10) << 4) | ((block6 >>> 28) & MASK_4));
      for (int shift = 14; shift >= 0; shift -= 14) {
        intPairs.putLong((block6 >>> shift) & MASK_14);
      }
    }
  }

  private static void decode15(ByteBuffer in, ByteBuffer intPairs) {

    for (int k = 0; k < 2; ++k) {
      long block0 = in.getLong();
      for (int shift = 17; shift >= 0; shift -= 15) {
        intPairs.putLong((block0 >>> shift) & MASK_15);
      }
      long block1 = in.getLong();
      intPairs.putLong(((block0 & MASK_2) << 13) | ((block1 >>> 19) & MASK_13));
      intPairs.putLong((block1 >>> 4) & MASK_15);
      long block2 = in.getLong();
      intPairs.putLong(((block1 & MASK_4) << 11) | ((block2 >>> 21) & MASK_11));
      intPairs.putLong((block2 >>> 6) & MASK_15);
      long block3 = in.getLong();
      intPairs.putLong(((block2 & MASK_6) << 9) | ((block3 >>> 23) & MASK_9));
      intPairs.putLong((block3 >>> 8) & MASK_15);
      long block4 = in.getLong();
      intPairs.putLong(((block3 & MASK_8) << 7) | ((block4 >>> 25) & MASK_7));
      intPairs.putLong((block4 >>> 10) & MASK_15);
      long block5 = in.getLong();
      intPairs.putLong(((block4 & MASK_10) << 5) | ((block5 >>> 27) & MASK_5));
      intPairs.putLong((block5 >>> 12) & MASK_15);
      long block6 = in.getLong();
      intPairs.putLong(((block5 & MASK_12) << 3) | ((block6 >>> 29) & MASK_3));
      intPairs.putLong((block6 >>> 14) & MASK_15);
      long block7 = in.getLong();
      intPairs.putLong(((block6 & MASK_14) << 1) | ((block7 >>> 31) & MASK_1));
      for (int shift = 16; shift >= 0; shift -= 15) {
        intPairs.putLong((block7 >>> shift) & MASK_15);
      }
      long block8 = in.getLong();
      intPairs.putLong(((block7 & MASK_1) << 14) | ((block8 >>> 18) & MASK_14));
      intPairs.putLong((block8 >>> 3) & MASK_15);
      long block9 = in.getLong();
      intPairs.putLong(((block8 & MASK_3) << 12) | ((block9 >>> 20) & MASK_12));
      intPairs.putLong((block9 >>> 5) & MASK_15);
      long block10 = in.getLong();
      intPairs.putLong(((block9 & MASK_5) << 10) | ((block10 >>> 22) & MASK_10));
      intPairs.putLong((block10 >>> 7) & MASK_15);
      long block11 = in.getLong();
      intPairs.putLong(((block10 & MASK_7) << 8) | ((block11 >>> 24) & MASK_8));
      intPairs.putLong((block11 >>> 9) & MASK_15);
      long block12 = in.getLong();
      intPairs.putLong(((block11 & MASK_9) << 6) | ((block12 >>> 26) & MASK_6));
      intPairs.putLong((block12 >>> 11) & MASK_15);
      long block13 = in.getLong();
      intPairs.putLong(((block12 & MASK_11) << 4) | ((block13 >>> 28) & MASK_4));
      intPairs.putLong((block13 >>> 13) & MASK_15);
      long block14 = in.getLong();
      intPairs.putLong(((block13 & MASK_13) << 2) | ((block14 >>> 30) & MASK_2));
      for (int shift = 15; shift >= 0; shift -= 15) {
        intPairs.putLong((block14 >>> shift) & MASK_15);
      }
    }
  }

  private static void decode16(ByteBuffer in, ByteBuffer intPairs) {

    for (int k = 0; k < 32; ++k) {
      long block0 = in.getLong();
      for (int shift = 16; shift >= 0; shift -= 16) {
        intPairs.putLong((block0 >>> shift) & MASK_16);
      }
    }
  }

}
