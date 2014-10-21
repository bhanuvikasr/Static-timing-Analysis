public class node1
{
    private final int mID;
    private String mValue;
    private String mDevice;

    public node1(int x)
    {
        mID = x;
    }

    public int getID()
    {
        return mID;
    }

    public void setValue(String value)
    {
        this.mValue = value;
    }

    public String getValue()
    {
        return (mValue);
    }

    public void setDevice(String Device)
    {
        mDevice = Device;
    }

    public String getDevice()
    {
        return (mDevice);
    }

    public String toString()
    {
        return (this.getValue());
    }
}
