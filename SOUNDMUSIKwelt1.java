import java.io.File;
import javax.sound.sampled.*;
public class SOUNDMUSIKwelt1
{
    private Clip clip;
    public SOUNDMUSIKwelt1()
    {
        try 
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("weltmusik1.wav"));  //hier .wav datei einfügen
            AudioFormat format = ais.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format, ((int) ais.getFrameLength() * format.getFrameSize()));
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(0.4F);
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
