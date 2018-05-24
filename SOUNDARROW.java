import java.io.File;
import javax.sound.sampled.*;
public class SOUNDARROW
{
    private Clip clip;
    public SOUNDARROW() 
    {
        try 
        {
                AudioInputStream ais = AudioSystem.getAudioInputStream(new File("pfeilschuss.wav"));  //hier .wav datei einfügen
            AudioFormat format = ais.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format, ((int) ais.getFrameLength() * format.getFrameSize()));
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(1.0F);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public void play() 
    {
        clip.start();
    }

    public void stop() 
    {
        clip.stop();
    }
}