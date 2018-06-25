import java.io.File;
import javax.sound.sampled.*;
public class SOUNDSCHWERTSCHLAG
{
    private Clip clip;
    public SOUNDSCHWERTSCHLAG() 
    {
        try 
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("schwerthieb.wav"));  //hier .wav datei einfügen
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
        clip.loop(0);
    }
    
    public void playgeg() {
        clip.loop(0);
    }

    public void stop() 
    {
        clip.stop();
    }
}