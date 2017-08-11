package test.cyberhouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLUpdate {
	  static Connection con = MySQLConnections.getConnection();
	    static PreparedStatement stmt = null;
	    
	    
	    public static void executeInsert1(String ProgramReference,String AwardTitle,String Investigator,String AwardInstrument,String ProgramOfficer,
	    	String FoaInformation,String Organization,String MaxAmdLetterDate,String AwardID,String Institution,String AwardExpirationDate,
	    	String ProgramElement,String MinAmdLetterDate,String AwardEffectiveDate,String AwardAmount,String AbstractNarration	
	    		) throws SQLException {
	        stmt = con.prepareStatement("insert into test (ProgramReference,AwardTitle,Investigator,AwardInstrument,ProgramOfficer,FoaInformation,"
	        +"Organization,MaxAmdLetterDate,AwardID,Institution,AwardExpirationDate,ProgramElement,MinAmdLetterDate,AwardEffectiveDate,AwardAmount,AbstractNarration)"+
	        		" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	        // 关闭事务自动提交 ,这一行必须加上
	        con.setAutoCommit(false);
            stmt.setString(1, ProgramReference);  
            stmt.setString(2, AwardTitle);  
            stmt.setString(3, Investigator);  
            stmt.setString(4, AwardInstrument);  
            stmt.setString(5, ProgramOfficer);  
            stmt.setString(6, FoaInformation);  
            stmt.setString(7, Organization);  
            stmt.setString(8, MaxAmdLetterDate);  
            stmt.setString(9, AwardID);  
            stmt.setString(10, Institution);  
            stmt.setString(11, AwardExpirationDate);  
            stmt.setString(12, ProgramElement);  
            stmt.setString(13, MinAmdLetterDate);  
            stmt.setString(14, AwardEffectiveDate);  
            stmt.setString(15, AwardAmount);  
            stmt.setString(16, AbstractNarration);  
	        stmt.addBatch();  
            stmt.executeBatch();
            con.commit();
	    }

	    public static  void executeInsert2() throws SQLException {
	        // 关闭事务自动提交 ,这一行必须加上  
	        con.setAutoCommit(false);
	        stmt = con.prepareStatement("insert into test (ProgramReference,AwardTitle)  "
	                + "values (?,?)");
	        for (int j = 0; j < 5; j++){
	        	stmt.setString(1, j+"ProgramReference");  
		        stmt.setString(2, j+"AwardTitle");  
	            stmt.addBatch(); 
	        }
	        stmt.executeBatch();
	        con.commit();
	        stmt.close();   
	        con.close();
	    }
	    
	    
	    public static void main(String[] args) throws SQLException {
//	      long begin1 = System.currentTimeMillis(); 
//	      MySQLUpdate.executeInsert();
//	      long end1 = System.currentTimeMillis();  
//	      System.out.println("程序运行时间为："+(end1-begin1));

	        long begin2 = System.currentTimeMillis(); 
	        MySQLUpdate.executeInsert2();
	        long end2 = System.currentTimeMillis();  
	        System.out.println("程序运行时间为："+(end2-begin2));
	        
	    }

}
