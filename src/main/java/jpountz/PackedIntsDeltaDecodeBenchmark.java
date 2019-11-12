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
public class PackedIntsDeltaDecodeBenchmark {

  @Benchmark
  public void naiveDecodeAndPrefixSum(PackedIntsDecodeState state, Blackhole bh) {
    SIMDDecoder.decode(state.bitsPerValue, state.input, state.tmpLongs, state.outputLongs);
    prefixSum(state.outputLongs);
    bh.consume(state.outputLongs);
  }

  private static void prefixSum(long[] arr) {
    for (int i = 1; i < 128; ++i) {
      arr[i] += arr[i-1];
    }
  }

  @Benchmark
  public void naiveDecodeAndUnrolledPrefixSum(PackedIntsDecodeState state, Blackhole bh) {
    SIMDDecoder.decode(state.bitsPerValue, state.input, state.tmpLongs, state.outputLongs);
    unrolledPrefixSum(state.outputLongs);
    bh.consume(state.outputLongs);
  }

  private static void unrolledPrefixSum(long[] arr) {
    arr[1] += arr[0];
    arr[2] += arr[1];
    arr[3] += arr[2];
    arr[4] += arr[3];
    arr[5] += arr[4];
    arr[6] += arr[5];
    arr[7] += arr[6];
    arr[8] += arr[7];
    arr[9] += arr[8];
    arr[10] += arr[9];
    arr[11] += arr[10];
    arr[12] += arr[11];
    arr[13] += arr[12];
    arr[14] += arr[13];
    arr[15] += arr[14];
    arr[16] += arr[15];
    arr[17] += arr[16];
    arr[18] += arr[17];
    arr[19] += arr[18];
    arr[20] += arr[19];
    arr[21] += arr[20];
    arr[22] += arr[21];
    arr[23] += arr[22];
    arr[24] += arr[23];
    arr[25] += arr[24];
    arr[26] += arr[25];
    arr[27] += arr[26];
    arr[28] += arr[27];
    arr[29] += arr[28];
    arr[30] += arr[29];
    arr[31] += arr[30];
    arr[32] += arr[31];
    arr[33] += arr[32];
    arr[34] += arr[33];
    arr[35] += arr[34];
    arr[36] += arr[35];
    arr[37] += arr[36];
    arr[38] += arr[37];
    arr[39] += arr[38];
    arr[40] += arr[39];
    arr[41] += arr[40];
    arr[42] += arr[41];
    arr[43] += arr[42];
    arr[44] += arr[43];
    arr[45] += arr[44];
    arr[46] += arr[45];
    arr[47] += arr[46];
    arr[48] += arr[47];
    arr[49] += arr[48];
    arr[50] += arr[49];
    arr[51] += arr[50];
    arr[52] += arr[51];
    arr[53] += arr[52];
    arr[54] += arr[53];
    arr[55] += arr[54];
    arr[56] += arr[55];
    arr[57] += arr[56];
    arr[58] += arr[57];
    arr[59] += arr[58];
    arr[60] += arr[59];
    arr[61] += arr[60];
    arr[62] += arr[61];
    arr[63] += arr[62];
    arr[64] += arr[63];
    arr[65] += arr[64];
    arr[66] += arr[65];
    arr[67] += arr[66];
    arr[68] += arr[67];
    arr[69] += arr[68];
    arr[70] += arr[69];
    arr[71] += arr[70];
    arr[72] += arr[71];
    arr[73] += arr[72];
    arr[74] += arr[73];
    arr[75] += arr[74];
    arr[76] += arr[75];
    arr[77] += arr[76];
    arr[78] += arr[77];
    arr[79] += arr[78];
    arr[80] += arr[79];
    arr[81] += arr[80];
    arr[82] += arr[81];
    arr[83] += arr[82];
    arr[84] += arr[83];
    arr[85] += arr[84];
    arr[86] += arr[85];
    arr[87] += arr[86];
    arr[88] += arr[87];
    arr[89] += arr[88];
    arr[90] += arr[89];
    arr[91] += arr[90];
    arr[92] += arr[91];
    arr[93] += arr[92];
    arr[94] += arr[93];
    arr[95] += arr[94];
    arr[96] += arr[95];
    arr[97] += arr[96];
    arr[98] += arr[97];
    arr[99] += arr[98];
    arr[100] += arr[99];
    arr[101] += arr[100];
    arr[102] += arr[101];
    arr[103] += arr[102];
    arr[104] += arr[103];
    arr[105] += arr[104];
    arr[106] += arr[105];
    arr[107] += arr[106];
    arr[108] += arr[107];
    arr[109] += arr[108];
    arr[110] += arr[109];
    arr[111] += arr[110];
    arr[112] += arr[111];
    arr[113] += arr[112];
    arr[114] += arr[113];
    arr[115] += arr[114];
    arr[116] += arr[115];
    arr[117] += arr[116];
    arr[118] += arr[117];
    arr[119] += arr[118];
    arr[120] += arr[119];
    arr[121] += arr[120];
    arr[122] += arr[121];
    arr[123] += arr[122];
    arr[124] += arr[123];
    arr[125] += arr[124];
    arr[126] += arr[125];
    arr[127] += arr[126];
  }

  @Benchmark
  public void mergeDecodeAndPrefixSum(PackedIntsDecodeState state, Blackhole bh) {
    SIMDDecoder.decodeAndPrefixSum(state.bitsPerValue, state.input, state.tmpLongs, state.outputLongs);
    bh.consume(state.outputLongs);
  }
}
