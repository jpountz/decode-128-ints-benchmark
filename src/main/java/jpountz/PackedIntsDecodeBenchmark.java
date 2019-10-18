package jpountz;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class PackedIntsDecodeBenchmark {

  @Benchmark
  public void decodeSimple(PackedIntsDecodeState state, Blackhole bh) {
    state.input.position(0);
    SimpleDecoder.decode(state.bitsPerValue, state.input, state.output);
    bh.consume(state.output);
  }

  @Benchmark
  public void decodeSIMD(PackedIntsDecodeState state, Blackhole bh) {
    state.input.position(0);
    SIMDDecoder.decode(state.bitsPerValue, state.input, state.output);
    bh.consume(state.output);
  }

  @Benchmark
  public void decodeSIMD2(PackedIntsDecodeState state, Blackhole bh) {
    state.input.position(0);
    SIMDDecoder2.decode(state.bitsPerValue, state.input, state.output);
    bh.consume(state.output);
  }

  @Benchmark
  public void decodeSIMDToHeapByteBuffer(PackedIntsDecodeState state, Blackhole bh) {
    state.input.position(0);
    state.outputHeapBB.position(0);
    SIMDDecoderToByteBuffer.decode(state.bitsPerValue, state.input, state.outputHeapBB);
    bh.consume(state.outputHeapBB);
  }

  @Benchmark
  public void decodeSIMDToDirectByteBuffer(PackedIntsDecodeState state, Blackhole bh) {
    state.input.position(0);
    state.outputDirectBB.position(0);
    SIMDDecoderToByteBuffer.decode(state.bitsPerValue, state.input, state.outputDirectBB);
    bh.consume(state.outputDirectBB);
  }

  @Benchmark
  public void decodeSIMDToLEHeapByteBuffer(PackedIntsDecodeState state, Blackhole bh) {
    state.input.position(0);
    state.outputLEHeapBB.position(0);
    SIMDDecoderToByteBuffer.decode(state.bitsPerValue, state.input, state.outputLEHeapBB);
    bh.consume(state.outputLEHeapBB);
  }

  @Benchmark
  public void decodeSIMDToLEDirectByteBuffer(PackedIntsDecodeState state, Blackhole bh) {
    state.input.position(0);
    state.outputLEDirectBB.position(0);
    SIMDDecoderToByteBuffer.decode(state.bitsPerValue, state.input, state.outputLEDirectBB);
    bh.consume(state.outputLEDirectBB);
  }

  @Benchmark
  public void decodeSIMDToHeapLongBuffer(PackedIntsDecodeState state, Blackhole bh) {
    state.input.position(0);
    state.outputHeapBBasLB.position(0);
    SIMDDecoderToLongBuffer.decode(state.bitsPerValue, state.input, state.outputHeapBBasLB);
    bh.consume(state.outputHeapBBasLB);
  }

  @Benchmark
  public void decodeSIMDToLEDirectLongBuffer(PackedIntsDecodeState state, Blackhole bh) {
    state.input.position(0);
    state.outputLEDirectBBasLB.position(0);
    SIMDDecoderToLongBuffer.decode(state.bitsPerValue, state.input, state.outputLEDirectBBasLB);
    bh.consume(state.outputLEDirectBBasLB);
  }
}
