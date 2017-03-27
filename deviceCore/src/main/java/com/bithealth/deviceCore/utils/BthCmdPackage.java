package com.bithealth.deviceCore.utils;


/**
 * 
 * @ClassName:     MiniHolterBleProtocol.java 
 * @Description:   用来获取命令包数据
 * @author         潘松南  
 * @version        V1.0   
 * @Date           2015-12-9 上午11:14:12
****
 */
public class BthCmdPackage {
    public static final char[] crc8_table = { 0x00, 0x07, 0x0E, 0x09, 0x1C, 0x1B, 0x12, 0x15, 0x38, 0x3F, 0x36, 0x31, 0x24, 0x23, 0x2A, 0x2D, 0x70, 0x77,
            0x7E, 0x79, 0x6C, 0x6B, 0x62, 0x65, 0x48, 0x4F, 0x46, 0x41, 0x54, 0x53, 0x5A, 0x5D, 0xE0, 0xE7, 0xEE, 0xE9, 0xFC, 0xFB, 0xF2, 0xF5, 0xD8, 0xDF,
            0xD6, 0xD1, 0xC4, 0xC3, 0xCA, 0xCD, 0x90, 0x97, 0x9E, 0x99, 0x8C, 0x8B, 0x82, 0x85, 0xA8, 0xAF, 0xA6, 0xA1, 0xB4, 0xB3, 0xBA, 0xBD, 0xC7, 0xC0,
            0xC9, 0xCE, 0xDB, 0xDC, 0xD5, 0xD2, 0xFF, 0xF8, 0xF1, 0xF6, 0xE3, 0xE4, 0xED, 0xEA, 0xB7, 0xB0, 0xB9, 0xBE, 0xAB, 0xAC, 0xA5, 0xA2, 0x8F, 0x88,
            0x81, 0x86, 0x93, 0x94, 0x9D, 0x9A, 0x27, 0x20, 0x29, 0x2E, 0x3B, 0x3C, 0x35, 0x32, 0x1F, 0x18, 0x11, 0x16, 0x03, 0x04, 0x0D, 0x0A, 0x57, 0x50,
            0x59, 0x5E, 0x4B, 0x4C, 0x45, 0x42, 0x6F, 0x68, 0x61, 0x66, 0x73, 0x74, 0x7D, 0x7A, 0x89, 0x8E, 0x87, 0x80, 0x95, 0x92, 0x9B, 0x9C, 0xB1, 0xB6,
            0xBF, 0xB8, 0xAD, 0xAA, 0xA3, 0xA4, 0xF9, 0xFE, 0xF7, 0xF0, 0xE5, 0xE2, 0xEB, 0xEC, 0xC1, 0xC6, 0xCF, 0xC8, 0xDD, 0xDA, 0xD3, 0xD4, 0x69, 0x6E,
            0x67, 0x60, 0x75, 0x72, 0x7B, 0x7C, 0x51, 0x56, 0x5F, 0x58, 0x4D, 0x4A, 0x43, 0x44, 0x19, 0x1E, 0x17, 0x10, 0x05, 0x02, 0x0B, 0x0C, 0x21, 0x26,
            0x2F, 0x28, 0x3D, 0x3A, 0x33, 0x34, 0x4E, 0x49, 0x40, 0x47, 0x52, 0x55, 0x5C, 0x5B, 0x76, 0x71, 0x78, 0x7F, 0x6A, 0x6D, 0x64, 0x63, 0x3E, 0x39,
            0x30, 0x37, 0x22, 0x25, 0x2C, 0x2B, 0x06, 0x01, 0x08, 0x0F, 0x1A, 0x1D, 0x14, 0x13, 0xAE, 0xA9, 0xA0, 0xA7, 0xB2, 0xB5, 0xBC, 0xBB, 0x96, 0x91,
            0x98, 0x9F, 0x8A, 0x8D, 0x84, 0x83, 0xDE, 0xD9, 0xD0, 0xD7, 0xC2, 0xC5, 0xCC, 0xCB, 0xE6, 0xE1, 0xE8, 0xEF, 0xFA, 0xFD, 0xF4, 0xF3 };

    /* 上位机--->采集器 */
    /**cmd命令码：请求采集器配置信息 */
    public static final byte CMD_REQ_CONFIG = 0x02;
    /**cmd命令码：修改配置信息*/
    public static final byte CMD_REQ_MODIFY_CONFIG = 0x04;
    /**cmd命令码：请求采集器实时上传数据 */
    public static final byte CMD_REQ_CUR_UPLOAD = 0x05;
    /**cmd命令码：请求采集器历史文件信息 */
    public static final byte CMD_REQ_HISTORY_FILE_INFO = 0x07;
    /**cmd命令码：请求采集器上传历史数据 */
    public static final byte CMD_REQ_UPLOAD_HISTORY_FILE = 0x09;
    /**cmd命令码：请求删除历史文件 */
    public static final byte CMD_REQ_DEL_HISTORY_FILE = 0x0C;
    /**cmd命令码：请求停止采集 */
    public static final byte CMD_REQ_STOP_COLLECT = 0x0D;
    /**cmd命令码：请求应答包 */
    public static final byte CMD_REQ_REPLAY_ACK_PACKAGE = (byte) 0xAA;
    /**cmd命令码：请求断线包 */
    public static final byte CMD_REQ_DISCONNECT_PACKAGE = (byte) 0xAB;
    /**cmd命令码：请求电量信息 */
    public static final byte CMD_REQ_ELECTRIC = (byte) 0x10;
    /**cmd命令码：采集器不做处理，直接存入文件*/
    public static final byte CMD_REQ_SAVE_IN_FILE = (byte) 0x0F;

    /* 采集器--->上位机 */
    /**cmd命令码：回应采集器配置信息 */
    public static final byte CMD_RESPONSE_CONFIG = 0x03;
    /**cmd命令码：采集器实时上传测量数据 */
    public static final byte CMD_RESPONSE_CURUPLOAD = 0x06;
    /**cmd命令码：采集器回应历史文件信息 */
    public static final byte CMD_RESPONSE_HISTORY_FILE_INFO = 0x08;
    /**cmd命令码：采集器上传历史数据 */
    public static final byte CMD_RESPONSE_UPLOAD_HISTORY_FILE = 0x0A;
    /**cmd命令码：采集器上传历史数据结束 */
    public static final byte CMD_RESPONSE_UPLOAD_HISTORY_FILE_END = 0x0B;
    /**cmd命令码：采集器发送蓝牙地址 */
    public static final byte CMD_RESPONSE_MAC_ADDRESS = (byte) 0x0E;
    /**cmd命令码：采集器发送电量信息 */
    public static final byte CMD_RESPONSE_ELECTRIC = (byte) 0x11;
    
    /**
     * 通用响应包
     */
    public static final byte CMD_RESPONSE_ACK = (byte) 0xAA;
    
    /**
     * 正确响应包
     */
//    public static final byte[] rightACK= {(byte) 0xAA,(byte) 0xFE,(byte) 0xAA,0x01,0x00,0x33,0x00,0x00};

    /**
     * 
     * @Title: calcCrc8 
     * @Description: crc8校验 
     * @param data
     * @param len
     * @return    
     * @retrun byte
     */
    public static byte calcCrc8(byte[] data, int len) {
        byte ret = 0;
        int i = 0;
        while (len-- > 0) {
            ret = (byte) crc8_table[(0x00ff & (ret ^ data[i++]))];
        }
        return ret;
    }

    /**
     * 
     * @Title: getSumchk 
     * @Description: 对 DATA的和校验，不考虑溢出，就一个字节 
     * @param data
     * @return    
     * @retrun byte
     */
    public static byte getSumchk(byte[] data) {
        int sum = 0;
        for (byte by : data) {
            sum += by & 0xFF;
        }
        return (byte) sum;
    }

    /**
     * 
     * @Title: twoByteToInt 
     * @Description: 将两个字节转化为一个int值 
     * @param b0
     * @param b1
     * @return    
     * @retrun int
     */
    public static int twoByteToInt(byte b0, byte b1) {
        int i0 = b0 & 0xFF;
        int i1 = (b1 & 0xFF) << 8;
        return i0 | i1;
    }

    /**
     * 
     * @Title: getSaveInFilePackage 
     * @Description: 请求保存数据到采集器的文件中 
     * @param data
     * @return    
     * @retrun byte[]
     */
    public static byte[] getSaveInFilePackage(byte[] data) {
        return getPackage((byte) CMD_REQ_SAVE_IN_FILE, data);
    }

    /**
     * 
     * @Title: getElectricPackage 
     * @Description: 请求电量信息
     * @return    
     * @retrun byte[]
     */
    public static byte[] getElectricPackage() {
        return getPackage((byte) CMD_REQ_ELECTRIC, null);
    }

    /**
     * 
     * @Title: getGetConfigPackage 
     * @Description: 请求采集器配置信息发送 
     * @return    
     * @retrun byte[]
     */
    public static byte[] getGetConfigPackage() {
        return getPackage((byte) CMD_REQ_CONFIG, null);
    }

    /**
     * 
     * @Title: getSetConfigPackage 
     * @Description: 【修改配置信息】暂时不做 
     * @return    
     * @retrun byte[]
     */
    public static byte[] getSetConfigPackage(byte[] data) {
        return getPackage(CMD_REQ_MODIFY_CONFIG, data);
    }

    /**
     * 
     * @Title: getReqCurUploadPackage 
     * @Description: 请求采集器实时上传数据 
     * @param data
     * @return    
     * @retrun byte[]
     */
    public static byte[] getReqCurUploadPackage() {
        return getPackage((byte) CMD_REQ_CUR_UPLOAD, null);
    }

    /**
     * 
     * @Title: getGetHistoryFileInfoPackage 
     * @Description: 请求采集器历史文件信息 
     * @return    
     * @retrun byte[]
     */
    public static byte[] getGetHistoryFileInfoPackage() {
        return getPackage((byte) CMD_REQ_HISTORY_FILE_INFO, null);
    }

    /**
     * 
     * @Title: getReqUploadHistoryFilePackage 
     * @Description: 请求采集器上传历史数据 
     * @param data
     * @return    
     * @retrun byte[]
     */
    public static byte[] getReqUploadHistoryFilePackage(byte[] data) {
        return getPackage((byte) CMD_REQ_UPLOAD_HISTORY_FILE, data);
    }

    /**
     * 
     * @Title: getDeleteHistoryFilePackage 
     * @Description: 删除历史文件 
     * @param data
     * @return    
     * @retrun byte[]
     */
    public static byte[] getDeleteHistoryFilePackage(byte[] data) {
        return getPackage((byte) CMD_REQ_DEL_HISTORY_FILE, data);
    }

    /**
     * 
     * @Title: getStopCollectPackage 
     * @Description: 停止采集 
     * @return    
     * @retrun byte[]
     */
    public static byte[] getStopCollectPackage() {
        return getPackage((byte) CMD_REQ_STOP_COLLECT, null);
    }

    /**
     * 
     * @Title: getReplayAckPackage 
     * @Description: 应答包 
     * @param data
     * @return    
     * @retrun byte[]
     */
    public static byte[] getReplayAckPackage(byte[] data) {
        return getPackage((byte) CMD_REQ_REPLAY_ACK_PACKAGE, data);
    }

    /**
     * 
     * @Title: getDisconnectPackage 
     * @Description: 断线包 
     * @param data
     * @return    
     * @retrun byte[]
     */
    public static byte[] getDisconnectPackage(byte[] data) {
        return getPackage((byte) CMD_REQ_DISCONNECT_PACKAGE, data);
    }

    /**
     * 
     * @Title: getPackage 
     * @Description: 通用，获取命令数据包 
     * @param cmdcode 命令代码
     * @param data 业务数据
     * @return    
     * @retrun byte[]
     */
    private static byte[] getPackage(byte cmdcode, byte[] data) {
        int dataLength = data == null ? 0 : data.length;// 业务数据长度
        byte[] pack = new byte[7 + dataLength];
        pack[0] = (byte) 0xAA;
        pack[1] = (byte) 0xFE;// LEADCODE数据包头
        pack[2] = cmdcode;// 命令代码
        pack[3] = (byte) dataLength;// 业务数据长度，用两个字节表示（低位）
        pack[4] = (byte) (dataLength >> 8);// 业务数据长度，用两个字节表示（高位）
        pack[5] = calcCrc8(pack, 5);// crc8 数据包头验证码
        if (data != null) {// 业务数据放入发送的数据包中
            for (int i = 6; i < 6 + dataLength; i++) {
                pack[i] = data[i - 6];
            }
        }
        pack[pack.length - 1] = (data == null ? 0 : getSumchk(data));// 计算业务数据校验和

        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < pack.length; j++) {
            sb.append(String.format("%02X", pack[j] & 0xFF));
            // 间隔开，方便看
            if (j == 1) {// 数据包头
                sb.append(" ");
            }
            if (j == 2) {// cmd码
                sb.append(" ");
            }
            if (j == 4) {// 数据包长度
                sb.append(" ");
            }
            if (j == 5) {// crc8校验码
                sb.append(" ");
            }
            if (j == 5 + pack.length) {// sumchk
                sb.append(" ");
            }
        }
       // Log.i("package", sb.toString());
        return pack;
    }
    
    
    
    /**
     * 十六进制字符串装十进制
     * 
     * @param hex
     *            十六进制字符串
     * @return 十进制数值
     */
    public static int hexStringToAlgorism(String hex) {
        hex = hex.toUpperCase();
        int max = hex.length();
        int result = 0;
        for (int i = max; i > 0; i--) {
            char c = hex.charAt(i - 1);
            int algorism = 0;
            if (c >= '0' && c <= '9') {
                algorism = c - '0';
            } else {
                algorism = c - 55;
            }
            result += Math.pow(16, max - i) * algorism;
        }
        return result;
    }
    
    
    /**
     * ASCII码字符串转数字字符串
     * 
     * @param String
     *            ASCII字符串
     * @return 字符串
     */
    public static String AsciiStringToString(String content) {
        String result = "";
        int length = content.length() / 2;
        for (int i = 0; i < length; i++) {
            String c = content.substring(i , i +1);
            int a = hexStringToAlgorism(c);
            char b = (char) a;
            String d = String.valueOf(b);
            result += d;
        }
        return result;
    }
    
    public static String convertStringToHex(String str){
	  	  char[] chars = str.toCharArray();
	
	  	  StringBuffer hex = new StringBuffer();
	  	  for(int i = 0; i < chars.length; i++){
	  	    hex.append(Integer.toHexString((int)chars[i]));
	  	  }
	  	  return hex.toString();
  	}
   
    /**
     * @Title:convertStringToDexAndGetSum 
     * @Description:将asc码转换成十进制数字并求和
     * @author 谢美团
     * @param str
     * @return 
     * @throws
     * @retrun String
     */ 
    public static int convertStringToDexAndGetSum(String str){
	  	  char[] chars = str.toCharArray();
	  	  int sumDex = 0;
	  	  for(int i = 0; i < chars.length; i++){
	  		sumDex = sumDex + Integer.parseInt(Integer.toHexString((int)chars[i]), 16);
	  	  }
	  	  return sumDex;
	}
    
  	/**
  	 * @Title:IntToHex 
  	 * @Description: 10进制转16进制
  	 * @author 谢美团
  	 * @param n
  	 * @return 
  	 * @throws
  	 * @retrun String
  	 */ 
  	public static String IntToHex(int n){
  		char[] ch = new char[20];
  		int nIndex = 0;
  		while ( true ){
  			int m = n/16;
  			int k = n%16;
  			if ( k == 15 )
  				ch[nIndex] = 'F';
  			else if ( k == 14 )
  				ch[nIndex] = 'E';
  			else if ( k == 13 )
  				ch[nIndex] = 'D';
  			else if ( k == 12 )
  				ch[nIndex] = 'C';
  			else if ( k == 11 )
  				ch[nIndex] = 'B';
  			else if ( k == 10 )
  				ch[nIndex] = 'A';
  			else 
  				ch[nIndex] = (char)('0' + k);
  			nIndex++;
  			if ( m == 0 )
  				break;
  			n = m;
  		}
  		StringBuffer sb = new StringBuffer();
  		sb.append(ch, 0, nIndex);
  		sb.reverse();
  		return sb.toString();
  	}
    
  	
	/**
	 * @Title:xor 
	 * @Description:两个十六进制的异或运算
	 * @author 谢美团
	 * @param strHex_X
	 * @param strHex_Y
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	public static String xor(String strHex_X,String strHex_Y){ 
		//将x、y转成二进制形式 
		String anotherBinary=Integer.toBinaryString(Integer.valueOf(strHex_X,16)); 
		String thisBinary=Integer.toBinaryString(Integer.valueOf(strHex_Y,16)); 
		String result = ""; 
		//判断是否为8位二进制，否则左补零 
		if(anotherBinary.length() != 8){ 
		for (int i = anotherBinary.length(); i <8; i++) { 
				anotherBinary = "0"+anotherBinary; 
			} 
		} 
		if(thisBinary.length() != 8){ 
		for (int i = thisBinary.length(); i <8; i++) { 
				thisBinary = "0"+thisBinary; 
			} 
		} 
		//异或运算 
		for(int i=0;i<anotherBinary.length();i++){ 
		//如果相同位置数相同，则补0，否则补1 
			if(thisBinary.charAt(i)==anotherBinary.charAt(i)) 
				result+="0"; 
			else{ 
				result+="1"; 
			} 
			}
		return Integer.toHexString(Integer.parseInt(result, 2)); 
	}
}
