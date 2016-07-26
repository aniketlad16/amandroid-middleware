package customUtil

import java.io._

/**
  * Created by Aniket on 6/17/16.
  */
class DictionarySerialize {

  def serializeMethod (seriVal: Int ): Unit = {

    try
    {
      val fileOut = new FileOutputStream("/Users/Aniket/Documents/activator-1.3.10-minimal/bin/amandroid-middleware/ResourceFiles/dict.ser")
      val out = new ObjectOutputStream(fileOut)
      out.writeObject(seriVal)
      out.close()
      fileOut.close()
      System.out.println("Serialized data is saved in /ResourceFiles/dict.ser")
    }catch
    {
      case ioe: IOException =>
        ioe.printStackTrace()
    }


  }

  def deserializableMethod () : Int = {

    var deseriVal: Int = 0

    try
    {
      val fileIn = new FileInputStream("/Users/Aniket/Documents/activator-1.3.10-minimal/bin/amandroid-middleware/ResourceFiles/dict.ser")
      val in = new ObjectInputStream(fileIn)
      deseriVal =  in.readObject().asInstanceOf[Int]
      in.close()
      fileIn.close();
    }catch
    {
      case i: IOException =>
      return 0

      case e: ClassNotFoundException =>
        System.out.println("Employee class not found")
        return 0

    }

    return deseriVal
  }


}
