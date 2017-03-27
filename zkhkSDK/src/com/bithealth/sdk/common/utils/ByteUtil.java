package com.bithealth.sdk.common.utils;

/** 
 *  
 * <ul> 
 * <li>文件名称: com.hkbithealth.util.ByteUtil</li> 
 * <li>文件描述: byte转换工具</li> 
* <li>版权所有: 版权所有(C)2001-2026</li> 
* <li>公 司: huikang</li> 
 * <li>内容摘要:</li> 
 * <li>其他说明:</li> 
 * <li>完成日期：2016-4-21</li> 
 * <li>修改记录0：无</li> 
 * </ul> 
 *  
 * @version 1.0 
 * @author  柴仕富 
 */  
public class ByteUtil {  
    /** 
     * 转换short为byte 
     *  
     * @param b 
     * @param s 
     *            需要转换的short 
     * @param index 
 
     */  
    public static void putShort(byte b[], short s, int index) {  
        b[index + 1] = (byte) (s >> 8);  
        b[index + 0] = (byte) (s >> 0);  
    }  
  
    /** 
     * 通过byte数组取到short 
     *  
     * @param b 
     * @param index 
     *            第几位开始取 
     * @return 
     */  
    public static short getShort(byte[] b, int index) {  
        return (short) (((b[index + 1] << 8) | b[index + 0] & 0xff));  
    }  
  
    /** 
     * 转换int为byte数组 
     *  
     * @param bb 
     * @param x 
     * @param index 
     */  
    public static byte[]   putInt(byte[] bb, int x, int index) {  
        bb[index + 3] = (byte) (x >> 24);  
      bb[index + 2] = (byte) (x >> 16);  
      bb[index + 1] = (byte) (x >> 8);  
      bb[index + 0] = (byte) (x >> 0);  
      return bb;
  }  
    
    /** 
     * 基于位移的int转化成byte[] 
     * @param int  number 
     * @return byte[] 
     */  
      
    public static byte[] intToByte(int number) {  
        byte[] abyte = new byte[4];  
        // "&" 与（AND），对两个整型操作数中对应位执行布尔代数，两个位都为1时输出1，否则0。  
        abyte[0] = (byte) (0xff & number);  
        // ">>"右移位，若为正数则高位补0，若为负数则高位补1  
        abyte[1] = (byte) ((0xff00 & number) >> 8);  
        abyte[2] = (byte) ((0xff0000 & number) >> 16);  
        abyte[3] = (byte) ((0xff000000 & number) >> 24);  
        return abyte;  
    }  
      
    public static byte[] intToBytes(int n) {
        byte[] b = new byte[4];
        b[3] = (byte) (n & 0xff);
        b[2] = (byte) (n >> 8 & 0xff);
        b[1] = (byte) (n >> 16 & 0xff);
        b[0] = (byte) (n >> 24 & 0xff);
        return b;
    }
    
  //byte 与 int 的相互转换  
    public static byte int2ToByte(int x) {  
        return (byte) x;  
    }  
    
    public static void intToBytes( int n, byte[] array, int offset ){
        array[3+offset] = (byte) (n & 0xff);
        array[2+offset] = (byte) (n >> 8 & 0xff);
        array[1+offset] = (byte) (n >> 16 & 0xff);
        array[offset] = (byte) (n >> 24 & 0xff);
    }    
    
    /** 
     *基于位移的 byte[]转化成int 
     * @param byte[] bytes 
     * @return int  number 
     */  
      
//    public static int bytesToInt(byte[] bytes) {  
//        int number = bytes[0] & 0xFF;  
//        // "|="按位或赋值。  
//        number |= ((bytes[1] << 8) & 0xFF00);  
//        number |= ((bytes[2] << 16) & 0xFF0000);  
//        number |= ((bytes[3] << 24) & 0xFF000000);  
//        return number;  
//    }  
    
    
    public static int bytesToInt(byte b[]) {
        return    b[3] & 0xff 
               | (b[2] & 0xff) << 8 
               | (b[1] & 0xff) << 16
               | (b[0] & 0xff) << 24;
    }

    public static int bytesToInt(byte b[], int offset) {
        return    b[offset+3] & 0xff 
               | (b[offset+2] & 0xff) << 8 
               | (b[offset+1] & 0xff) << 16
               | (b[offset] & 0xff) << 24;
    }
    

  /** 
   * 通过byte数组取到int 
   *  
   * @param bb 
   * @param index 
   *            第几位开始 
   * @return 
   */  
  public static int getInt(byte[] bb, int index) {  
      return (int) ((((bb[index + 3] & 0xff) << 24)  
              | ((bb[index + 2] & 0xff) << 16)  
              | ((bb[index + 1] & 0xff) << 8) | ((bb[index + 0] & 0xff) << 0)));  
  }  

  /** 
   * 转换long型为byte数组 
   *  
   * @param bb 
   * @param x 
   * @param index 
   */  
  public static void putLong(byte[] bb, long x, int index) {  
      bb[index + 7] = (byte) (x >> 56);  
      bb[index + 6] = (byte) (x >> 48);  
      bb[index + 5] = (byte) (x >> 40);  
      bb[index + 4] = (byte) (x >> 32);  
      bb[index + 3] = (byte) (x >> 24);  
      bb[index + 2] = (byte) (x >> 16);  
      bb[index + 1] = (byte) (x >> 8);  
      bb[index + 0] = (byte) (x >> 0);  
  }  

  /** 
   * 通过byte数组取到long 
   *  
   * @param bb 
   * @param index 
   * @return 
   */  
  public static long getLong(byte[] bb, int index) {  
       return ((((long) bb[index + 7] & 0xff) << 56)  
               | (((long) bb[index + 6] & 0xff) << 48)  
                | (((long) bb[index + 5] & 0xff) << 40)  
                | (((long) bb[index + 4] & 0xff) << 32)  
                | (((long) bb[index + 3] & 0xff) << 24)  
                | (((long) bb[index + 2] & 0xff) << 16)  
                | (((long) bb[index + 1] & 0xff) << 8) | (((long) bb[index + 0] & 0xff) << 0));  
    }  
  
    /** 
     * 字符到字节转换 
     *  
     * @param ch 
     * @return 
     */  
    public static void putChar(byte[] bb, char ch, int index) {  
        int temp = (int) ch;  
        // byte[] b = new byte[2];  
        for (int i = 0; i < 2; i ++ ) {  
            bb[index + i] = new Integer(temp & 0xff).byteValue(); // 将最高位保存在最低位  
            temp = temp >> 8; // 向右移8位  
        }  
    }  
  
    /** 
     * 字节到字符转换 
     *  
     * @param b 
     * @return 
     */  
    public static char getChar(byte[] b, int index) {  
        int s = 0;  
        if (b[index + 1] > 0)  
            s += b[index + 1];  
        else  
            s += 256 + b[index + 0];  
        s *= 256;  
        if (b[index + 0] > 0)  
            s += b[index + 1];  
        else  
            s += 256 + b[index + 0];  
        char ch = (char) s;  
        return ch;  
    }  
  
    /** 
     * float转换byte 
     *  
     * @param bb 
     * @param x 
     * @param index 
     */  
    public static void putFloat(byte[] bb, float x, int index) {  
        // byte[] b = new byte[4];  
        int l = Float.floatToIntBits(x);  
        for (int i = 0; i < 4; i++) {  
            bb[index + i] = new Integer(l).byteValue();  
            l = l >> 8;  
        }  
    }  
  
    /** 
     * 通过byte数组取得float 
     *  
     * @param bb 
     * @param index 
     * @return 
     */  
    public static float getFloat(byte[] b, int index) {  
        int l;  
        l = b[index + 0];  
        l &= 0xff;  
        l |= ((long) b[index + 1] << 8);  
        l &= 0xffff;  
        l |= ((long) b[index + 2] << 16);  
        l &= 0xffffff;  
        l |= ((long) b[index + 3] << 24);  
        return Float.intBitsToFloat(l);  
    }  
  
    /** 
     * double转换byte 
     *  
     * @param bb 
     * @param x 
     * @param index 
     */  
    public static void putDouble(byte[] bb, double x, int index) {  
        // byte[] b = new byte[8];  
        long l = Double.doubleToLongBits(x);  
        for (int i = 0; i < 4; i++) {  
            bb[index + i] = new Long(l).byteValue();  
            l = l >> 8;  
        }  
    }  
  
    /** 
     * 通过byte数组取得float 
     *  
     * @param bb 
     * @param index 
     * @return 
     */  
    public static double getDouble(byte[] b, int index) {  
        long l;  
        l = b[0];  
        l &= 0xff;  
        l |= ((long) b[1] << 8);  
        l &= 0xffff;  
        l |= ((long) b[2] << 16);  
        l &= 0xffffff;  
        l |= ((long) b[3] << 24);  
        l &= 0xffffffffl;  
        l |= ((long) b[4] << 32);  
        l &= 0xffffffffffl;  
        l |= ((long) b[5] << 40);  
        l &= 0xffffffffffffl;  
        l |= ((long) b[6] << 48);  
        l &= 0xffffffffffffffl;  
        l |= ((long) b[7] << 56);  
        return Double.longBitsToDouble(l);  
    }  
} 
