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
  public void decodeNaiveFromBytes(PackedIntsDecodeState state, Blackhole bh) {
    NaiveByteDecoder.decode(state.bitsPerValue, state.input, state.tmpBytes, state.outputInts);
    bh.consume(state.outputInts);
  }

  @Benchmark
  public void decodeNaiveFromLongs(PackedIntsDecodeState state, Blackhole bh) {
    NaiveLongDecoder.decode(state.bitsPerValue, state.input, state.outputLongs);
    bh.consume(state.outputLongs);
  }

  @Benchmark
  public void decodeC2SIMD(PackedIntsDecodeState state, Blackhole bh) {
    C2SIMDDecoder.decode(state.bitsPerValue, state.input, state.tmpInts, state.outputInts);
    bh.consume(state.outputInts);
  }

  @Benchmark
  public void decodeSIMDEmulator(PackedIntsDecodeState state, Blackhole bh) {
    SIMDEmulatorDecoder.decode(state.bitsPerValue, state.input, state.tmpLongs, state.outputLongs);
    bh.consume(state.outputLongs);
  }

}
