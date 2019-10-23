package jpountz;

import java.nio.ByteBuffer;

/**
 * Decoder that only relies on how Java's C2 compiler recognizes some patterns
 * to generate SIMD instructions. 
 */
public class C2SIMDDecoder {

  /**
   * Decode 128 integers into {@code ints}.
   */
  static void decode(int bitsPerValue, ByteBuffer in, int[] tmp, int[] ints) {
    switch (bitsPerValue) {
    case 1:
      decode1(in, tmp, ints);
      break;
    case 2:
      decode2(in, tmp, ints);
      break;
    case 3:
      decode3(in, tmp, ints);
      break;
    case 4:
      decode4(in, tmp, ints);
      break;
    case 5:
      decode5(in, tmp, ints);
      break;
    case 6:
      decode6(in, tmp, ints);
      break;
    case 8:
      decode8(in, tmp, ints);
      break;
    case 10:
      decode10(in, tmp, ints);
      break;
    case 16:
      decode16(in, tmp, ints);
      break;
    default:
      throw new UnsupportedOperationException();
    }
  }

  /**
   * The pattern that this shiftInts method applies is recognized by the C2
   * compiler, which generates SIMD instructions for it in order to shift
   * multiple ints at once.
   */
  private static void shiftInts(int[] a, int count, int[] b, int bi, int shift, int mask) {
    for (int i = 0; i < count; ++i) {
      b[bi+i] = (a[i] >>> shift) & mask;
    }
  }

  private static void decode1(ByteBuffer in, int[] tmp, int[] ints) {
    in.asIntBuffer().get(tmp, 0, 4);
    shiftInts(tmp, 4, ints, 0, 31, 1);
    shiftInts(tmp, 4, ints, 4, 30, 1);
    shiftInts(tmp, 4, ints, 8, 29, 1);
    shiftInts(tmp, 4, ints, 12, 28, 1);
    shiftInts(tmp, 4, ints, 16, 27, 1);
    shiftInts(tmp, 4, ints, 20, 26, 1);
    shiftInts(tmp, 4, ints, 24, 25, 1);
    shiftInts(tmp, 4, ints, 28, 24, 1);
    shiftInts(tmp, 4, ints, 32, 23, 1);
    shiftInts(tmp, 4, ints, 36, 22, 1);
    shiftInts(tmp, 4, ints, 40, 21, 1);
    shiftInts(tmp, 4, ints, 44, 20, 1);
    shiftInts(tmp, 4, ints, 48, 19, 1);
    shiftInts(tmp, 4, ints, 52, 18, 1);
    shiftInts(tmp, 4, ints, 56, 17, 1);
    shiftInts(tmp, 4, ints, 60, 16, 1);
    shiftInts(tmp, 4, ints, 64, 15, 1);
    shiftInts(tmp, 4, ints, 68, 14, 1);
    shiftInts(tmp, 4, ints, 72, 13, 1);
    shiftInts(tmp, 4, ints, 76, 12, 1);
    shiftInts(tmp, 4, ints, 80, 11, 1);
    shiftInts(tmp, 4, ints, 84, 10, 1);
    shiftInts(tmp, 4, ints, 88, 9, 1);
    shiftInts(tmp, 4, ints, 92, 8, 1);
    shiftInts(tmp, 4, ints, 96, 7, 1);
    shiftInts(tmp, 4, ints, 100, 6, 1);
    shiftInts(tmp, 4, ints, 104, 5, 1);
    shiftInts(tmp, 4, ints, 108, 4, 1);
    shiftInts(tmp, 4, ints, 112, 3, 1);
    shiftInts(tmp, 4, ints, 116, 2, 1);
    shiftInts(tmp, 4, ints, 120, 1, 1);
    shiftInts(tmp, 4, ints, 124, 0, 1);
  }

  private static void decode2(ByteBuffer in, int[] tmp, int[] ints) {
    in.asIntBuffer().get(tmp, 0, 8);
    shiftInts(tmp, 8, ints, 0, 30, 3);
    shiftInts(tmp, 8, ints, 8, 28, 3);
    shiftInts(tmp, 8, ints, 16, 26, 3);
    shiftInts(tmp, 8, ints, 24, 24, 3);
    shiftInts(tmp, 8, ints, 32, 22, 3);
    shiftInts(tmp, 8, ints, 40, 20, 3);
    shiftInts(tmp, 8, ints, 48, 18, 3);
    shiftInts(tmp, 8, ints, 56, 16, 3);
    shiftInts(tmp, 8, ints, 64, 14, 3);
    shiftInts(tmp, 8, ints, 72, 12, 3);
    shiftInts(tmp, 8, ints, 80, 10, 3);
    shiftInts(tmp, 8, ints, 88, 8, 3);
    shiftInts(tmp, 8, ints, 96, 6, 3);
    shiftInts(tmp, 8, ints, 104, 4, 3);
    shiftInts(tmp, 8, ints, 112, 2, 3);
    shiftInts(tmp, 8, ints, 120, 0, 3);
  }

  private static void decode3(ByteBuffer in, int[] tmp, int[] ints) {
    in.asIntBuffer().get(tmp, 0, 13);
    shiftInts(tmp, 13, ints, 0, 27, 7);
    shiftInts(tmp, 13, ints, 13, 24, 7);
    shiftInts(tmp, 13, ints, 26, 21, 7);
    shiftInts(tmp, 13, ints, 39, 18, 7);
    shiftInts(tmp, 13, ints, 52, 15, 7);
    shiftInts(tmp, 13, ints, 65, 12, 7);
    shiftInts(tmp, 13, ints, 78, 9, 7);
    shiftInts(tmp, 13, ints, 91, 6, 7);
    shiftInts(tmp, 13, ints, 104, 3, 7);
    shiftInts(tmp, 13, ints, 117, 0, 7);
  }

  private static void decode4(ByteBuffer in, int[] tmp, int[] ints) {
    in.asIntBuffer().get(tmp, 0, 16);
    shiftInts(tmp, 16, ints, 0, 28, 15);
    shiftInts(tmp, 16, ints, 16, 24, 15);
    shiftInts(tmp, 16, ints, 32, 20, 15);
    shiftInts(tmp, 16, ints, 48, 16, 15);
    shiftInts(tmp, 16, ints, 64, 12, 15);
    shiftInts(tmp, 16, ints, 80, 8, 15);
    shiftInts(tmp, 16, ints, 96, 4, 15);
    shiftInts(tmp, 16, ints, 112, 0, 15);
  }

  private static void decode5(ByteBuffer in, int[] tmp, int[] ints) {
    in.asIntBuffer().get(tmp, 0, 22);
    shiftInts(tmp, 22, ints, 0, 25, 31);
    shiftInts(tmp, 22, ints, 22, 20, 31);
    shiftInts(tmp, 22, ints, 44, 15, 31);
    shiftInts(tmp, 22, ints, 66, 10, 31);
    shiftInts(tmp, 22, ints, 88, 5, 31);
    shiftInts(tmp, 22, ints, 110, 0, 31);
  }

  private static void decode6(ByteBuffer in, int[] tmp, int[] ints) {
    in.asIntBuffer().get(tmp, 0, 26);
    shiftInts(tmp, 26, ints, 0, 24, 63);
    shiftInts(tmp, 26, ints, 26, 18, 63);
    shiftInts(tmp, 26, ints, 52, 12, 63);
    shiftInts(tmp, 26, ints, 78, 6, 63);
    shiftInts(tmp, 26, ints, 104, 0, 63);
  }

  private static void decode8(ByteBuffer in, int[] tmp, int[] ints) {
    in.asIntBuffer().get(tmp, 0, 32);
    shiftInts(tmp, 32, ints, 0, 24, 255);
    shiftInts(tmp, 32, ints, 32, 16, 255);
    shiftInts(tmp, 32, ints, 64, 8, 255);
    shiftInts(tmp, 32, ints, 96, 0, 255);
  }

  private static void decode10(ByteBuffer in, int[] tmp, int[] ints) {
    in.asIntBuffer().get(tmp, 0, 43);
    shiftInts(tmp, 43, ints, 0, 20, 1023);
    shiftInts(tmp, 43, ints, 43, 10, 1023);
    shiftInts(tmp, 43, ints, 86, 0, 1023);
  }

  private static void decode16(ByteBuffer in, int[] tmp, int[] ints) {
    in.asIntBuffer().get(tmp, 0, 64);
    shiftInts(tmp, 64, ints, 0, 16, 65535);
    shiftInts(tmp, 64, ints, 64, 0, 65535);
  }

}
