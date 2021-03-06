public class IpFormat
{

	public static void main(String[] args){

	}

	public static long ipToLong(String ipAddress){
		//ipAddress = "202.112.34.12";
		long result = 0;
		String[] atoms = ipAddress.split("\\.");
		
		for(int i=3; i>=0; i--){
			result |= (Long.parseLong(atoms[3-i]) << (i * 8));
		}
		
		return result & 0xFFFFFFFF;
	}	

	public static String longToIp(long ip){
		StringBuilder sb = new StringBuilder(15);	
		
		for(int i=0; i<4; i++){
			sb.insert(0,Long.toString(ip & 0xff));
			if(i<3){
				sb.insert(0,'.');
			}
			ip >>= 8;
		}
		return sb.toString();
	}
}