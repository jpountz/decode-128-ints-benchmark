package jpountz;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;
import java.util.Random;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class PackedIntsDecodeState {

  // Read data from a ByteBuffer 
  ByteBuffer input;
  long[] output;
  ByteBuffer outputHeapBB;
  ByteBuffer outputLEHeapBB;
  ByteBuffer outputDirectBB;
  ByteBuffer outputLEDirectBB;
  LongBuffer outputHeapBBasLB;
  LongBuffer outputLEDirectBBasLB;

  @Param({ "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" })
  int bitsPerValue;

  @Setup(Level.Trial)
  public void init() {
    // Use a Big Endian direct ByteBuffer as the input, which should be similar
    // enough to reading from a MMapDirectory.
    input = ByteBuffer.allocateDirect(128 * Integer.BYTES);
    Random r = new Random(0);
    byte[] b = new byte[128 * Integer.BYTES];
    r.nextBytes(b);
    input.put(b);

    output = new long[128];

    outputHeapBB = ByteBuffer.allocate(128 * 4);
    outputLEHeapBB = ByteBuffer.allocate(128 * 4).order(ByteOrder.LITTLE_ENDIAN);

    outputDirectBB = ByteBuffer.allocateDirect(128 * 4);
    outputLEDirectBB = ByteBuffer.allocateDirect(128 * 4).order(ByteOrder.LITTLE_ENDIAN);

    // Don't create a direct long buffer but a view of a ByteBuffer so that its bytes
    // could be interpreted as ints as well via asIntBuffer().
    outputHeapBBasLB = outputHeapBB.asLongBuffer();
    outputLEDirectBBasLB = outputLEDirectBB.asLongBuffer();
  }

}
