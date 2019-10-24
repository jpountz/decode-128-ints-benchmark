package jpountz;

import java.nio.ByteBuffer;

/** A decoder that just reads the right number of longs without actually decoding. */
public class NoopDecoder {

  static void decode(int bitsPerValue, ByteBuffer in, long[] longs) {
    in.asLongBuffer().get(longs, 0, bitsPerValue * 2);
  }

}
