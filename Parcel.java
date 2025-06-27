public class Parcel
{
    private String parcelID;
    private String senderName;
    private String senderAddress;
    private String senderContactNo;
    private String receiverName;
    private String receiverAddress;
    private String receiverContactNo;
    private double parcelWeight;
    private int parcelAddress;
    private boolean Fragile;
    private String DateOut;
    private String DateIn;

    public Parcel()
    {
        parcelID=null;
        senderName=null;
        senderAddress=null;
        senderContactNo=null;
        receiverName=null;
        receiverAddress=null;
        receiverContactNo=null;
        parcelWeight=0.0;
        parcelAddress=0;
        Fragile=false;
        DateOut=null;
        DateIn=null;
    }
    
    public Parcel(String parcelID,String senderName,String senderAddress,String senderContactNo,String receiverName,String receiverAddress,String receiverContactNo,double parcelWeight,int parcelAddress,boolean Fragile,String DateOut,String DateIn)
    {
        this.parcelID=parcelID;
        this.senderName=senderName;
        this.senderAddress=senderAddress;
        this.senderContactNo=senderContactNo;
        this.receiverName=receiverName;
        this.receiverAddress=receiverAddress;
        this.receiverContactNo=receiverContactNo;
        this.parcelWeight=parcelWeight;
        this.parcelAddress=parcelAddress;
        this.Fragile=Fragile;
        this.DateOut=DateOut;
        this.DateIn=DateIn;
    }
    
    public String getParcelID(){return parcelID;}
    public String getSenderName(){return senderName;}
    public String getSenderAddress(){return senderAddress;}
    public String getSenderContactNo(){return senderContactNo;}
    public String getReceiverName(){return receiverName;}
    public String getReceiverAddress(){return receiverAddress;}
    public String getReceiverContactNo(){return receiverContactNo;}
    public double getParcelWeight(){return parcelWeight;}
    public int getParcelAddress(){return parcelAddress;}
    public boolean getFragile(){return Fragile;}
    public String getDateOut(){return DateOut;} 
    public String getDateIn(){return DateIn;}
    
    public void setParcelID(String parcelID){this.parcelID = parcelID;}
    public void setSenderName(String senderName){this.senderName = senderName;}
    public void setSenderAddress(String senderAddress){this.senderAddress = senderAddress;}
    public void setSenderContactNo(String senderContactNo){this.senderContactNo = senderContactNo;}
    public void setReceiverName(String receiverName){this.receiverName = receiverName;}
    public void setReceiverAddress(String receiverAddress){this.receiverAddress = receiverAddress;}
    public void setReceiverContactNo(String receiverContactNo){this.parcelID = receiverContactNo;}
    public void setParcelWeight(double parcelWeight){this.parcelWeight = parcelWeight;}
    public void setParcelAddress(int parcelAddress)
    {
        this.parcelAddress = parcelAddress;
    }
    public void setFragile(boolean Fragile){this.Fragile = Fragile;}
    public void setDateOut(String DateOut){this.DateOut = DateOut;}
    public void setDateIn(String DateIn){this.DateIn = DateIn;}
    
    public void DisplayInfo()
    {
        System.out.println(String.format("|%-4s|%-25s|%-25s|%-15s|%-22s|%-20s|%-15s|%-4s|",parcelID,senderName,senderAddress,senderContactNo,receiverName,receiverAddress,receiverContactNo,parcelAddress));
    }
    
    public String printInfo()
    {
        return String.format("|%-4s|%-25s|%-25s|%-15s|%-22s|%-20s|%-15s|%-4s|",parcelID,senderName,senderAddress,senderContactNo,receiverName,receiverAddress,receiverContactNo,parcelAddress);
    }
}