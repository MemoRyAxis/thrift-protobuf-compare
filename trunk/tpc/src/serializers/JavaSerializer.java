package serializers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import serializers.java.Image;
import serializers.java.Media;
import serializers.java.MediaContent;
import serializers.java.Image.Size;
import serializers.java.Media.Player;


public class JavaSerializer implements ObjectSerializer<MediaContent>
{

  public MediaContent deserialize (byte[] array) throws Exception
  {
    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(array));
    try
    {
      return (MediaContent)ois.readObject();
    }
    finally
    {
      ois.close();
    }
  }

  public byte[] serialize(MediaContent content) throws IOException, Exception
  {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(content);
    oos.close();
    byte[] array = baos.toByteArray();
    return array;
  }

  public MediaContent create()
  {
    Media media = new Media(null, "video/mpg4", Player.JAVA, "Javaone Keynote", "http://javaone.com/keynote.mpg", 1234567, 123, 0, 0, 0);
    media.addToPerson("Bill Gates");
    media.addToPerson("Steve Jobs");

    Image image1 = new Image(0, "Javaone Keynote", "A", 0, Size.LARGE);
    Image image2 = new Image(0, "Javaone Keynote", "B", 0, Size.SMALL);

    MediaContent content = new MediaContent(media);
    content.addImage(image1);
    content.addImage(image2);
    return content;
  }

  public String getName ()
  {
    return "java";
  }
}