package com.geoxp.heatmap;

import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

/**
 * Collection of coloring palettes for HeatMaps.
 * 
 * Each int is ARGB (Alpha Red Green Blue)
 * 
 */
public class ColorMap {
	
  private static Map<String, int[]> cache = new HashMap<String, int[]>();
  
  private static final int MAX_CACHE_ENTRIES = 16;
  
  public static final int[] BLACK_HIGH = { 0xff000000,0xff010101,0xff020202,0xff030303,0xff040404,0xff050505,0xff060606,0xff070707,0xff080808,0xff090909,0xff0a0a0a,0xff0b0b0b,0xff0c0c0c,0xff0d0d0d,0xff0e0e0e,0xff0f0f0f,0xff101010,0xff111111,0xff121212,0xff131313,0xff141414,0xff151515,0xff161616,0xff171717,0xff181818,0xff191919,0xff1a1a1a,0xff1b1b1b,0xff1c1c1c,0xff1d1d1d,0xff1e1e1e,0xff1f1f1f,0xff202020,0xff212121,0xff222222,0xff232323,0xff242424,0xff252525,0xff262626,0xff272727,0xff282828,0xff292929,0xff2a2a2a,0xff2b2b2b,0xff2c2c2c,0xff2d2d2d,0xff2e2e2e,0xff2f2f2f,0xff303030,0xff313131,0xff323232,0xff333333,0xff343434,0xff353535,0xff363636,0xff373737,0xff383838,0xff393939,0xff3a3a3a,0xff3b3b3b,0xff3c3c3c,0xff3d3d3d,0xff3e3e3e,0xff3f3f3f,0xff404040,0xff414141,0xff424242,0xff434343,0xff444444,0xff454545,0xff464646,0xff474747,0xff484848,0xff494949,0xff4a4a4a,0xff4b4b4b,0xff4c4c4c,0xff4d4d4d,0xff4e4e4e,0xff4f4f4f,0xff505050,0xff515151,0xff525252,0xff535353,0xff545454,0xff555555,0xff565656,0xff575757,0xff585858,0xff595959,0xff5a5a5a,0xff5b5b5b,0xff5c5c5c,0xff5d5d5d,0xff5e5e5e,0xff5f5f5f,0xff606060,0xff616161,0xff626262,0xff636363,0xff646464,0xff656565,0xff666666,0xff676767,0xff686868,0xff696969,0xff6a6a6a,0xff6b6b6b,0xff6c6c6c,0xff6d6d6d,0xff6e6e6e,0xff6f6f6f,0xff707070,0xff717171,0xff727272,0xff737373,0xff747474,0xff757575,0xff767676,0xff777777,0xff787878,0xff797979,0xff7a7a7a,0xff7b7b7b,0xff7c7c7c,0xff7d7d7d,0xff7e7e7e,0xff7f7f7f,0xff808080,0xff818181,0xff828282,0xff838383,0xff848484,0xff858585,0xff868686,0xff878787,0xff888888,0xff898989,0xff8a8a8a,0xff8b8b8b,0xff8c8c8c,0xff8d8d8d,0xff8e8e8e,0xff8f8f8f,0xff909090,0xff919191,0xff929292,0xff939393,0xff949494,0xff959595,0xff969696,0xff979797,0xff989898,0xff999999,0xff9a9a9a,0xff9b9b9b,0xff9c9c9c,0xff9d9d9d,0xff9e9e9e,0xff9f9f9f,0xffa0a0a0,0xffa1a1a1,0xffa2a2a2,0xffa3a3a3,0xffa4a4a4,0xffa5a5a5,0xffa6a6a6,0xffa7a7a7,0xffa8a8a8,0xffa9a9a9,0xffaaaaaa,0xffababab,0xffacacac,0xffadadad,0xffaeaeae,0xffafafaf,0xffb0b0b0,0xffb1b1b1,0xffb2b2b2,0xffb3b3b3,0xffb4b4b4,0xffb5b5b5,0xffb6b6b6,0xffb7b7b7,0xffb8b8b8,0xffb9b9b9,0xffbababa,0xffbbbbbb,0xffbcbcbc,0xffbdbdbd,0xffbebebe,0xffbfbfbf,0xffc0c0c0,0xffc1c1c1,0xffc2c2c2,0xffc3c3c3,0xffc4c4c4,0xffc5c5c5,0xffc6c6c6,0xffc7c7c7,0xffc8c8c8,0xffc9c9c9,0xffcacaca,0xffcbcbcb,0xffcccccc,0xffcdcdcd,0xffcecece,0xffcfcfcf,0xffd0d0d0,0xffd1d1d1,0xffd2d2d2,0xffd3d3d3,0xffd4d4d4,0xffd5d5d5,0xffd6d6d6,0xffd7d7d7,0xffd8d8d8,0xffd9d9d9,0xffdadada,0xffdbdbdb,0xffdcdcdc,0xffdddddd,0xffdedede,0xffdfdfdf,0xffe0e0e0,0xffe1e1e1,0xffe2e2e2,0xffe3e3e3,0xffe4e4e4,0xffe5e5e5,0xffe6e6e6,0xffe7e7e7,0xffe8e8e8,0xffe9e9e9,0xffeaeaea,0xffebebeb,0xffececec,0xffededed,0xffeeeeee,0xffefefef,0xfff0f0f0,0xfff1f1f1,0xfff2f2f2,0xfff3f3f3,0xfff4f4f4,0xfff5f5f5,0xfff6f6f6,0xfff7f7f7,0xfff8f8f8,0xfff9f9f9,0xfffafafa,0xfffbfbfb,0xfffcfcfc,0xfffdfdfd,0xfffefefe,0x00ffffff};
  
  public static final int[] CLASSIC = { 0xffffeded,0xffffe0e0,0xffffd1d1,0xffffc1c1,0xffffb0b0,0xffff9f9f,0xffff8e8e,0xffff7e7e,
                                        0xffff6e6e,0xffff5e5e,0xffff5151,0xffff4343,0xffff3838,0xffff2e2e,0xffff2525,0xffff1d1d,
                                        0xffff1717,0xffff1212,0xffff0e0e,0xffff0b0b,0xffff0808,0xffff0606,0xffff0505,0xffff0303,
                                        0xffff0202,0xffff0202,0xffff0101,0xffff0101,0xffff0000,0xffff0000,0xffff0000,0xffff0000,
                                        0xffff0000,0xffff0000,0xffff0000,0xffff0000,0xffff0100,0xffff0400,0xffff0600,0xffff0a00,
                                        0xffff0e00,0xffff1200,0xffff1600,0xffff1a00,0xffff1f00,0xffff2400,0xffff2900,0xffff2d00,
                                        0xffff3300,0xffff3900,0xffff3e00,0xffff4400,0xffff4a00,0xffff5100,0xffff5600,0xffff5d00,
                                        0xffff6300,0xffff6900,0xffff6f00,0xffff7600,0xffff7c00,0xffff8300,0xffff8900,0xffff9000,
                                        0xffff9600,0xffff9c00,0xffffa300,0xffffa900,0xffffaf00,0xffffb500,0xffffbb00,0xffffc000,
                                        0xffffc600,0xffffcb00,0xffffd000,0xffffd500,0xffffda00,0xffffde00,0xffffe300,0xffffe800,
                                        0xffffeb00,0xffffee00,0xfffff200,0xfffff500,0xfffff700,0xfffffa00,0xfffffb00,0xfffdfc00,
                                        0xfffafc01,0xfff8fc02,0xfff4fc02,0xfff1fc03,0xffedfc03,0xffe9fc03,0xffe5fc04,0xffe1fc04,
                                        0xffdcfc05,0xffd8fc05,0xffd3fc06,0xffcefc07,0xffc9fc07,0xffc5fc08,0xffbffb08,0xffb9f909,
                                        0xffb4f709,0xffaef60a,0xffa9f40b,0xffa4f20b,0xff9ef00c,0xff97ee0d,0xff92ec0e,0xff8ce90e,
                                        0xff86e70f,0xff80e410,0xff7ae211,0xff74df12,0xff6edd13,0xff69da14,0xff63d815,0xff5dd616,
                                        0xff58d317,0xff52d118,0xff4ccf19,0xff47cc1a,0xff42ca1c,0xff3cc81e,0xff37c61f,0xff32c421,
                                        0xff2dc222,0xff28bf23,0xff24be25,0xff1fbc27,0xff1bbb28,0xff17b92b,0xff13b82c,0xff0fb72e,
                                        0xff0cb630,0xff09b533,0xff06b535,0xff03b437,0xff01b439,0xff00b43c,0xff00b43e,0xff00b441,
                                        0xff00b544,0xff00b646,0xff00b64a,0xff00b74d,0xff00b850,0xff00b854,0xff00ba58,0xff00bb5c,
                                        0xff00bc5f,0xff00be63,0xff00bf68,0xff00c16c,0xff00c270,0xff00c474,0xff00c678,0xff00c87d,
                                        0xff00c981,0xff00cb86,0xff00cd8a,0xff00cf8f,0xff00d193,0xff00d397,0xff00d59c,0xff00d7a0,
                                        0xff00d8a5,0xff00dbab,0xff00deb2,0xff00e0b8,0xff00e3be,0xff00e5c5,0xff00e7cb,0xff00e9d1,
                                        0xff00ead6,0xff00eadc,0xff00eae1,0xff00eae6,0xff00eaea,0xff00eaee,0xff00eaf2,0xff00eaf6,
                                        0xff00eaf8,0xff00eafb,0xff00eafe,0xff00eaff,0xff00e8ff,0xff00e4ff,0xff00e0ff,0xff00dbff,
                                        0xff00d6fe,0xff00d0fc,0xff00cafa,0xff00c3f7,0xff00bcf4,0xff00b4f0,0xff00adec,0xff00a4e8,
                                        0xff009ce4,0xff0093de,0xff008bda,0xff0082d5,0xff007ad0,0xff0075cd,0xff0070cb,0xff006bc7,
                                        0xff0063c4,0xff005dc1,0xff0056bd,0xff004eb8,0xff0047b4,0xff0041af,0xff003aab,0xff0034a7,
                                        0xff002ea2,0xff00289d,0xff002398,0xff001e93,0xff001a8e,0xff001688,0xff001283,0xff000f7e,
                                        0xff000c78,0xff000973,0xff01086e,0xff01066a,0xff010565,0xff020461,0xff03045c,0xff040559,
                                        0xff050555,0xff060652,0xff07074f,0xff08084d,0xff0a0a4d,0xff0c0c4d,0xff0e0e4c,0xff10104a,
                                        0xff131349,0xff151548,0xff181847,0xff1a1a45,0xff1d1d46,0xff202045,0xff232344,0xff252543,
                                        0xff282843,0xff2a2a41,0xff2c2c41,0xff2e2e40,0xff30303f,0xff31323e,0xff33333d,0x0035343d };
  
  public static final int[] FIRE = { 0xffffffff,0xfffffffd,0xfffffffa,0xfffffff7,0xfffffff4,0xfffffff1,0xffffffee,0xffffffea,
                                     0xffffffe7,0xffffffe3,0xffffffdf,0xffffffdb,0xffffffd6,0xffffffd3,0xffffffce,0xffffffca,
                                     0xffffffc5,0xffffffc0,0xffffffbb,0xffffffb7,0xffffffb2,0xffffffac,0xffffffa7,0xffffffa3,
                                     0xffffff9d,0xffffff98,0xffffff93,0xffffff8e,0xffffff88,0xffffff84,0xffffff7e,0xffffff79,
                                     0xffffff74,0xffffff6f,0xffffff6a,0xffffff66,0xffffff61,0xffffff5b,0xffffff57,0xffffff52,
                                     0xffffff4e,0xffffff4a,0xffffff46,0xffffff41,0xffffff3d,0xffffff39,0xffffff35,0xffffff32,
                                     0xffffff2e,0xffffff2b,0xffffff27,0xffffff26,0xffffff22,0xffffff1f,0xffffff1d,0xffffff1a,
                                     0xffffff19,0xfffffe17,0xfffffb16,0xfffffa16,0xfffff717,0xfffff517,0xfffff218,0xffffef18,
                                     0xffffec19,0xffffe819,0xffffe51a,0xffffe21a,0xffffde1b,0xffffda1b,0xffffd71c,0xffffd21c,
                                     0xffffcf1d,0xffffcb1d,0xffffc71e,0xffffc21e,0xffffbe1f,0xffffba1f,0xffffb620,0xffffb020,
                                     0xffffac21,0xffffa822,0xffffa322,0xffff9f23,0xffff9a23,0xffff9624,0xffff9124,0xffff8d25,
                                     0xffff8825,0xffff8426,0xffff8027,0xffff7c27,0xffff7728,0xffff7328,0xffff6f29,0xffff6b29,
                                     0xffff672a,0xffff632a,0xffff5f2b,0xffff5c2c,0xffff592c,0xffff552d,0xffff512d,0xffff4f2e,
                                     0xffff4c2f,0xffff482f,0xffff4630,0xffff4330,0xffff4131,0xffff3f32,0xffff3c32,0xffff3b33,
                                     0xffff3933,0xffff3734,0xffff3735,0xffff3535,0xfffd3636,0xfffd3636,0xfffb3737,0xfffa3838,
                                     0xfff83838,0xfff73939,0xfff63939,0xfff43a3a,0xfff23b3b,0xfff03b3b,0xffef3c3c,0xffee3d3d,
                                     0xffeb3d3d,0xffea3e3e,0xffe83e3e,0xffe53f3f,0xffe44040,0xffe24040,0xffe04141,0xffde4242,
                                     0xffdb4242,0xffda4343,0xffd84343,0xffd54444,0xffd34545,0xffd14545,0xffcf4646,0xffcd4747,
                                     0xffcb4747,0xffc84848,0xffc74949,0xffc44949,0xffc24a4a,0xffc04a4a,0xffbe4b4b,0xffbc4c4c,
                                     0xffba4c4c,0xffb74d4d,0xffb54e4e,0xffb34e4e,0xffb14f4f,0xffaf5050,0xffad5050,0xffaa5151,
                                     0xffa95252,0xffa65252,0xffa55353,0xffa25353,0xffa05454,0xff9e5555,0xff9c5555,0xff9a5656,
                                     0xff995757,0xff965757,0xff955858,0xff935959,0xff925a5a,0xff905b5b,0xff8e5c5c,0xff8e5e5e,
                                     0xff8d5f5f,0xff8c6060,0xff8b6262,0xff8a6363,0xff886464,0xff876565,0xff876767,0xff866868,
                                     0xff856969,0xff856b6b,0xff846c6c,0xff836d6d,0xff846f6f,0xff837070,0xff827171,0xff827272,
                                     0xff827474,0xff827575,0xff827676,0xff817777,0xff827979,0xff827a7a,0xff827b7b,0xff827c7c,
                                     0xff837e7e,0xff837f7f,0xff828080,0xff838181,0xff848383,0xff848484,0xff858585,0xff868686,
                                     0xff878787,0xff888888,0xff8a8a8a,0xff8b8b8b,0xff8c8c8c,0xff8d8d8d,0xff8e8e8e,0xff8f8f8f,
                                     0xff909090,0xff919191,0xff939393,0xff949494,0xff959595,0xff969696,0xff979797,0xff989898,
                                     0xff999999,0xff9a9a9a,0xff9b9b9b,0xff9c9c9c,0xff9d9d9d,0xff9e9e9e,0xff9f9f9f,0xffa0a0a0,
                                     0xffa0a0a0,0xffa1a1a1,0xffa2a2a2,0xffa3a3a3,0xffa4a4a4,0xffa5a5a5,0xffa6a6a6,0xffa7a7a7,
                                     0xffa7a7a7,0xffa8a8a8,0xffa9a9a9,0xffaaaaaa,0xffaaaaaa,0xffababab,0xffacacac,0xffadadad,
                                     0xffadadad,0xffaeaeae,0xffafafaf,0xffafafaf,0xffb0b0b0,0xffb0b0b0,0xffb1b1b1,0x00b1b1b1 };
  
  public static final int[] OMG = { 0xffffffff,0xfffffefe,0xfffffdfd,0xfffffbfb,0xfffffafa,0xfffff9f9,0xfffff7f7,0xfffff6f6,
                                    0xfffff4f4,0xfffff2f2,0xfffff1f1,0xffffefef,0xffffeded,0xffffebeb,0xffffe9e9,0xffffe7e7,
                                    0xffffe5e5,0xffffe3e3,0xffffe2e2,0xffffe0e0,0xffffdede,0xffffdcdc,0xffffd9d9,0xffffd7d7,
                                    0xffffd5d5,0xffffd2d2,0xffffd0d0,0xffffcece,0xffffcccc,0xffffcaca,0xffffc7c7,0xffffc5c5,
                                    0xffffc2c2,0xffffc0c0,0xffffbdbd,0xffffbcbc,0xffffb9b9,0xffffb7b7,0xffffb4b4,0xffffb2b2,
                                    0xffffb0b0,0xffffadad,0xffffabab,0xffffa9a9,0xffffa7a7,0xffffa4a4,0xffffa2a2,0xffffa0a0,
                                    0xffff9e9e,0xffff9b9b,0xffff9999,0xffff9797,0xffff9595,0xffff9393,0xffff9191,0xffff8f8f,
                                    0xffff8d8d,0xffff8b8b,0xffff8989,0xffff8888,0xffff8686,0xffff8484,0xffff8383,0xffff8181,
                                    0xffff8080,0xffff7f7f,0xffff7f7f,0xffff7e7e,0xffff7d7d,0xffff7d7d,0xffff7c7c,0xffff7b7a,
                                    0xffff7b7a,0xffff7a79,0xffff7a79,0xffff7978,0xffff7877,0xffff7776,0xffff7776,0xffff7674,
                                    0xffff7574,0xffff7573,0xffff7372,0xffff7372,0xffff7271,0xffff7270,0xffff716f,0xffff716f,
                                    0xffff706e,0xffff6f6c,0xffff6f6c,0xffff6e6b,0xffff6e6b,0xffff6d69,0xffff6d69,0xffff6c68,
                                    0xffff6b68,0xffff6b66,0xffff6a66,0xffff6a65,0xffff6965,0xffff6863,0xffff6863,0xffff6762,
                                    0xffff6762,0xffff6661,0xffff6660,0xffff6560,0xffff6560,0xffff645e,0xffff645e,0xffff635d,
                                    0xffff635c,0xffff625b,0xffff625b,0xffff615a,0xffff6159,0xffff6059,0xffff6059,0xffff5f58,
                                    0xffff5f58,0xffff5e56,0xffff5d56,0xffff5d55,0xffff5d55,0xffff5c55,0xffff5c54,0xffff5b53,
                                    0xffff5b53,0xffff5a52,0xffff5a52,0xffff5951,0xffff5952,0xffff5950,0xffff5950,0xffff594f,
                                    0xffff594f,0xffff584f,0xffff584f,0xffff574e,0xffff574e,0xffff574e,0xffff574d,0xffff574d,
                                    0xffff564d,0xffff564d,0xffff554c,0xffff554c,0xffff554b,0xffff554c,0xffff554b,0xffff554c,
                                    0xffff544b,0xffff544b,0xffff544b,0xffff544b,0xffff554b,0xffff544b,0xffff544b,0xffff534a,
                                    0xffff534b,0xffff534b,0xffff544b,0xffff534b,0xffff534b,0xffff534b,0xffff534b,0xffff534c,
                                    0xffff534c,0xffff534c,0xffff534c,0xffff534c,0xffff534c,0xffff534c,0xffff534c,0xffff534d,
                                    0xffff544e,0xffff534e,0xffff544f,0xffff544e,0xffff544f,0xffff534f,0xffff5450,0xffff5350,
                                    0xffff5451,0xffff5552,0xffff5552,0xffff5553,0xffff5553,0xffff5554,0xffff5554,0xffff5655,
                                    0xffff5655,0xffff5757,0xfffe5959,0xfffe5b5c,0xfffd5c5d,0xfffc5e60,0xfffb6062,0xfffb6164,
                                    0xfff96367,0xfff96469,0xfff8666c,0xfff7686f,0xfff66971,0xfff56b74,0xfff46d77,0xfff36e7a,
                                    0xfff2707d,0xfff1717f,0xfff07382,0xffef7586,0xffee7688,0xffed788c,0xffec798e,0xffeb7b91,
                                    0xffea7c94,0xffe97e97,0xffe87f9a,0xffe8819d,0xffe6829f,0xffe684a2,0xffe585a5,0xffe487a8,
                                    0xffe388aa,0xffe38aad,0xffe28bb0,0xffe18cb2,0xffe08eb5,0xffdf8fb7,0xffdf90b9,0xffdf92bc,
                                    0xffde93be,0xffdd94c0,0xffdd96c3,0xffdc97c5,0xffdb98c7,0xffdb99c9,0xffdb9aca,0xffdb9ccd,
                                    0xffda9dcf,0xffd99ed0,0xffd99fd2,0xffd9a0d3,0xffd9a1d5,0xffd8a2d6,0xffd8a3d8,0xffd8a4d9,
                                    0xffd7a5da,0xffd8a6db,0xffd7a6dc,0xffd7a7de,0xffd7a8df,0xffd7a9df,0xffd7aae0,0x00d7aae1 };
  
  public static final int[] PBJ = { 0xff290a59,0xff290a59,0xff2a0a59,0xff2a0a59,0xff2a0a58,0xff2b0a58,0xff2b0958,0xff2b0958,
                                    0xff2c0958,0xff2c0958,0xff2d0a59,0xff2e0a58,0xff2e0958,0xff2f0958,0xff2f0958,0xff2f0958,
                                    0xff300858,0xff300857,0xff310857,0xff310857,0xff310757,0xff320757,0xff320757,0xff330756,
                                    0xff330656,0xff350756,0xff350756,0xff360756,0xff360655,0xff370655,0xff370655,0xff380555,
                                    0xff380555,0xff390554,0xff390554,0xff3a0454,0xff3b0454,0xff3b0554,0xff3c0454,0xff3c0454,
                                    0xff3d0454,0xff3d0453,0xff3e0353,0xff3f0353,0xff3f0353,0xff400352,0xff400352,0xff410352,
                                    0xff420352,0xff430452,0xff440452,0xff450452,0xff450451,0xff460451,0xff470451,0xff470450,
                                    0xff480450,0xff490450,0xff49044f,0xff4b0550,0xff4c0550,0xff4d054f,0xff4d054f,0xff4e054f,
                                    0xff4f054e,0xff50054e,0xff50054e,0xff50054d,0xff51054d,0xff53064c,0xff53064c,0xff54064c,
                                    0xff55064b,0xff56064b,0xff57064a,0xff58064a,0xff580649,0xff590649,0xff5b0749,0xff5c0749,
                                    0xff5d0748,0xff5e0748,0xff5e0747,0xff5f0747,0xff600746,0xff600746,0xff610745,0xff630946,
                                    0xff640945,0xff650a45,0xff660a44,0xff670b43,0xff680b43,0xff690c42,0xff6a0d42,0xff6b0e42,
                                    0xff6c0f41,0xff6d1040,0xff6e1040,0xff6f113f,0xff70123e,0xff71123d,0xff72133d,0xff73143c,
                                    0xff76163c,0xff77163b,0xff78163a,0xff78173a,0xff791839,0xff7a1938,0xff7c1a37,0xff7d1b36,
                                    0xff7f1d36,0xff801e36,0xff821f35,0xff832034,0xff842133,0xff852232,0xff862331,0xff872430,
                                    0xff892630,0xff8a272f,0xff8c282e,0xff8d292e,0xff8e2a2d,0xff8f2a2c,0xff902b2b,0xff912c2a,
                                    0xff922d2a,0xff952f29,0xff963029,0xff973128,0xff983227,0xff993326,0xff9a3426,0xff9b3525,
                                    0xff9d3724,0xff9f3924,0xffa03923,0xffa03a22,0xffa23b21,0xffa33c21,0xffa43d20,0xffa53e1f,
                                    0xffa73f1e,0xffa8411e,0xffa9421d,0xffaa431d,0xffac441c,0xffad451b,0xffae461a,0xffaf471a,
                                    0xffb04719,0xffb24919,0xffb34a18,0xffb44b18,0xffb54c17,0xffb64d17,0xffb74e17,0xffb84f16,
                                    0xffba5016,0xffbb5115,0xffbc5215,0xffbd5315,0xffbe5314,0xffbf5414,0xffc05513,0xffc05613,
                                    0xffc15712,0xffc25712,0xffc45912,0xffc45a12,0xffc55a12,0xffc65a12,0xffc75b12,0xffc85c12,
                                    0xffc95d12,0xffca5d12,0xffcb5e12,0xffcc6013,0xffcc6013,0xffcd6113,0xffce6213,0xffcf6313,
                                    0xffd06313,0xffd16413,0xffd26413,0xffd36413,0xffd46614,0xffd56714,0xffd66714,0xffd66814,
                                    0xffd76914,0xffd76914,0xffd86a14,0xffd96b14,0xffda6b14,0xffdb6c14,0xffdc6d15,0xffdd6d15,
                                    0xffde6e15,0xffde6f15,0xffdf6f15,0xffe07015,0xffe17115,0xffe27115,0xffe37215,0xffe37215,
                                    0xffe47316,0xffe57416,0xffe57416,0xffe67516,0xffe77516,0xffe77616,0xffe87716,0xffe97716,
                                    0xffea7816,0xffea7816,0xffeb7916,0xffec7916,0xffed7a17,0xffed7a17,0xffee7b17,0xffef7c17,
                                    0xffef7c17,0xfff07d17,0xfff07d17,0xfff17e17,0xfff17e17,0xfff27f17,0xfff37f17,0xfff38017,
                                    0xfff48018,0xfff48018,0xfff58118,0xfff68118,0xfff68218,0xfff78218,0xfff78318,0xfff88318,
                                    0xfff98318,0xfff98418,0xfffa8418,0xfffa8518,0xfffa8518,0xfffa8518,0xfffb8618,0xfffb8619,
                                    0xfffc8719,0xfffc8719,0xfffd8719,0xfffd8819,0xfffd8819,0xfffe8819,0xfffe8819,0x00ff8919};
  
  public static final int[] PGAITCH = { 0xfffffea5,0xfffffea4,0xfffffda3,0xfffffda2,0xfffffda1,0xfffffca0,0xfffffc9f,0xfffffc9d,
                                        0xfffffb9c,0xfffffb9b,0xfffffb99,0xfffffa98,0xfffffa96,0xfffffa95,0xfffff994,0xfffff992,
                                        0xfffff991,0xfffff88f,0xfffff88d,0xfffff88b,0xfffff78a,0xfffff788,0xfffff686,0xfffff684,
                                        0xfffff682,0xfffff581,0xfffff57f,0xfffff57d,0xfffff47b,0xfffff479,0xfffff377,0xfffff375,
                                        0xfffff272,0xfffff270,0xfffff16f,0xfffff16d,0xfffff06b,0xfffff069,0xffffef66,0xffffef64,
                                        0xffffee63,0xffffee61,0xffffed5f,0xffffed5c,0xffffec5a,0xffffed59,0xffffec57,0xffffeb54,
                                        0xffffeb52,0xffffea50,0xffffe94f,0xffffe94d,0xffffe84a,0xffffe748,0xffffe646,0xffffe645,
                                        0xffffe543,0xffffe441,0xffffe33f,0xffffe23d,0xffffe13c,0xffffe13a,0xffffe038,0xffffdf36,
                                        0xffffde34,0xffffde33,0xffffdd31,0xffffdc2f,0xffffdb2e,0xffffda2c,0xffffd82b,0xffffd72a,
                                        0xffffd629,0xffffd527,0xffffd427,0xffffd325,0xffffd124,0xffffd022,0xffffd021,0xffffce21,
                                        0xffffcd20,0xffffcc1e,0xffffca1d,0xffffc91d,0xffffc71c,0xfffec71c,0xfffec71b,0xfffdc61b,
                                        0xfffcc51b,0xfffbc41b,0xfffac31a,0xfff9c31a,0xfff8c21a,0xfff8c11a,0xfff7c01a,0xfff6c019,
                                        0xfff5bf1a,0xfff4be1a,0xfff3bd19,0xfff1bc19,0xfff0bb19,0xffefbb19,0xffeeba19,0xffecb919,
                                        0xffecb81a,0xffebb71a,0xffe9b619,0xffe8b519,0xffe6b51a,0xffe5b41a,0xffe4b319,0xffe3b219,
                                        0xffe2b11a,0xffe0b01a,0xffdeb019,0xffddaf19,0xffdcad1a,0xffdbac1a,0xffd9ab19,0xffd7aa19,
                                        0xffd6aa1a,0xffd4a91a,0xffd3a719,0xffd1a619,0xffd0a61a,0xffcea51a,0xffcca31a,0xffcba21a,
                                        0xffcaa119,0xffc8a11a,0xffc69f1a,0xffc59e1a,0xffc39d1a,0xffc19d1b,0xffc09b1b,0xffbe9a1b,
                                        0xffbd991b,0xffbb981c,0xffba971c,0xffb8961c,0xffb6951c,0xffb5941d,0xffb3931d,0xffb1921d,
                                        0xffaf901d,0xffae901e,0xffac8e1e,0xffaa8d1e,0xffa98c1e,0xffa78b1f,0xffa58a1f,0xffa4891f,
                                        0xffa2881f,0xffa18720,0xff9f8620,0xff9d8520,0xff9a8420,0xff998321,0xff978221,0xff968121,
                                        0xff947f21,0xff937f22,0xff917e22,0xff8f7c22,0xff8d7b22,0xff8c7a23,0xff8b7923,0xff897823,
                                        0xff877723,0xff867624,0xff847524,0xff827424,0xff817324,0xff7f7124,0xff7e7125,0xff7c7025,
                                        0xff7a6f25,0xff796e25,0xff786d26,0xff766c26,0xff746b26,0xff736926,0xff716826,0xff706827,
                                        0xff6e6727,0xff6c6627,0xff6b6527,0xff6a6428,0xff686328,0xff666228,0xff656028,0xff636028,
                                        0xff636029,0xff615e29,0xff605d29,0xff5e5c29,0xff5c5b29,0xff5c5a2a,0xff5a5a2a,0xff59592a,
                                        0xff57572a,0xff56562a,0xff55562b,0xff54552b,0xff53542b,0xff51532b,0xff50522b,0xff50522c,
                                        0xff4e502c,0xff4d502c,0xff4b4f2c,0xff4b4e2c,0xff4a4e2d,0xff494c2d,0xff474b2d,0xff474b2d,
                                        0xff464a2d,0xff454a2e,0xff44492e,0xff43482e,0xff42472e,0xff41472e,0xff40452e,0xff40452f,
                                        0xff3f442f,0xff3e432f,0xff3d432f,0xff3c422f,0xff3b412f,0xff3b4130,0xff3b4030,0xff3a3f30,
                                        0xff393f30,0xff383e30,0xff383e30,0xff373d30,0xff373d31,0xff373c31,0xff373c31,0xff363b31,
                                        0xff353a31,0xff353931,0xff343931,0xff343932,0xff343832,0xff343832,0xff343832,0xff343732,
                                        0xff333632,0xff333532,0xff333532,0xff333432,0xff333533,0xff333533,0xff333433,0x00333433};
  
  public static int[] load(String file) throws Exception {
    BufferedImage image = ImageIO.read(new File(file));
    int[] palette = new int[image.getHeight()];
    for (int y=0; y < image.getHeight(); y++) {
      palette[y] = image.getRGB(0, y);
    }
    return palette;
  }
  
  public static int[] generate(int rgb) {
    int[] palette = new int[256];
    
    for (int i = 0; i < 256; i++) {
      palette[i] = ((255 - i) << 24) | rgb;
    }
    
    return palette;
  }

  public static int[] solid(int rgb) {
    int[] palette = new int[256];
    
    for (int i = 0; i < 255; i++) {
      palette[i] = 0xff000000 | rgb;
    }
    
    palette[255] = rgb;
    
    return palette;
  }
  
  public static int[] linearGradient(int rgbstart, int rgbstop) {
    
    double arate = (((rgbstop >> 24) & 0xff) - ((rgbstart >> 24) & 0xff)) / 255.0;
    double rrate = (((rgbstop >> 16) & 0xff) - ((rgbstart >> 16) & 0xff)) / 255.0;
    double grate = (((rgbstop >> 8) & 0xff) - ((rgbstart >> 8) & 0xff)) / 255.0;
    double brate = ((rgbstop & 0xff) - (rgbstart  & 0xff)) / 255.0;
    
    int[] palette = new int[256];
    
    for (int i = 0; i < 255; i++) {
      palette[i] = ((int) (rrate * i)) << 16;
      palette[i] |= ((int) (grate * i)) << 8;
      palette[i] |= ((int) (brate * i));
      palette[i] += (rgbstart & 0xffffff);
      palette[i] |= (((rgbstart >> 24) & 0xff) + (int) ((arate * i))) << 24;
    }
    
    // End color is transparent
    palette[255] = rgbstop & 0x00ffffff;
    
    return palette;
  }
  
  /**
   * Interpret a custom palette.
   * A custom palette is a String of hexdigits, grouped by 8 (4 bytes encoded), each
   * representing a color with an alpha channel AARRGGBB
   * 
   * @param hex
   * @return
   */
  public static int[] custom(String hex) {
    
    if (hex.length() > 2048) {
      return FIRE;
    }
    
    ByteBuffer bb = ByteBuffer.wrap(new BigInteger("ff" + hex, 16).toByteArray());
    
    int[] palette = new int[256];
    
    int last = (bb.array().length - 1) / 4;
    
    for (int i = 0; i < last; i++) {
      palette[i] = (bb.getInt(1 + i * 4) >> 8);
    }

    return palette;
  }
  
  public static int[] get(String p) {
    int[] palette = cache.get(p);
    
    if (null != palette) {
      return palette;
    }
    
    if (p.startsWith("solid:")) {
      palette = ColorMap.solid(Integer.valueOf(p.substring(6), 16));
    } else if (p.startsWith("alpha:")) {
      palette = ColorMap.generate(Integer.valueOf(p.substring(6), 16));
    } else if (p.startsWith("linear:")) {
      String[] tokens = p.split(":");
      if (3 == tokens.length) {
        palette = ColorMap.linearGradient(Long.valueOf(tokens[1], 16).intValue(), Long.valueOf(tokens[2], 16).intValue());
      }
    } else if ("fire".equals(p)) {
      palette = ColorMap.FIRE;
    } else if ("classic".equals(p)) {
      palette = ColorMap.CLASSIC;
    } else if ("omg".equals(p)) {
      palette = ColorMap.OMG;
    } else if ("pgaitch".equals(p)) {
      palette = ColorMap.PGAITCH;
    } else if ("pbj".equals(p)) {
      palette = ColorMap.PBJ;
    } else if ("black".equals(p)) {
      palette = ColorMap.BLACK_HIGH;
    } else if (p.startsWith("custom:")) {
      palette = ColorMap.custom(p.substring(7));
    }
 
    if (cache.size() > MAX_CACHE_ENTRIES) {
      cache.clear();
    }
    
    cache.put(p, palette);
    
    return palette;
  }
}
