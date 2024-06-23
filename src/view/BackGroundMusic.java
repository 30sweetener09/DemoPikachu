package view;


import javax.sound.sampled.*;
// import java.io.File;
import java.io.IOException;
import java.net.URL;
 
public class BackGroundMusic {
    private Clip audioClip;
    private boolean isPlaying = true;
 
    public BackGroundMusic(String filePath) {
        playBackgroundMusic(filePath);
    }
 
    private void playBackgroundMusic(String filePath) {
        try {
            // Đọc file từ resources
            URL soundFileURL = getClass().getClassLoader().getResource(filePath);
            if (soundFileURL == null) {
                System.err.println("File not found: " + filePath);
                return;
            }
 
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFileURL);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
 
            while (isPlaying) {
                Thread.sleep(1000);
            }
            audioClip.stop();
            audioClip.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    public void stopMusic() {
        isPlaying = false;
        System.out.println("Nhạc đã tắt.");
    }
}