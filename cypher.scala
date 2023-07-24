def Encrypt(string: String, shift: Int): String = {
  var encryptedText = ""

  for (char <- string) {
    val encryptedChar = ((char - 'A' + shift) % 26 + 'A').toChar
    encryptedText += encryptedChar
  }

  encryptedText
}

def Decrypt(string: String, shift: Int): String = {
  Encrypt(string, 26 - shift)
}

def Cipher(
    data: String,
    shift: Int,
    funtion: (String, Int) => String
): String = {
  funtion(data, shift)
}

def main(args: Array[String]): Unit = {

  println("Enter the text:-")
  val inputText = scala.io.StdIn.readLine()

  println("Enter the shift value:-")
  val shift = scala.io.StdIn.readInt()

  val encryptedText = Cipher(inputText, shift, Encrypt)
  val decryptedText = Cipher(encryptedText, shift, Decrypt)

  println("Encrypted Text:- " + encryptedText)
  println("Decrypted Text:- " + decryptedText)
}
