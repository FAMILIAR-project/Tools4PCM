package pcm

import scala.xml.PrettyPrinter
import scala.xml.Text
import scala.xml.XML
import scala.xml.Elem
import pcmmm.PcmmmFactory
import scala.collection.mutable.ListBuffer


class PCM {

  private val matrices : ListBuffer[Matrix] = new ListBuffer
  
  def getMatrices : List[Matrix] = {
    matrices.toList
  }

  def addMatrix(matrix : Matrix) = {
    matrices += matrix
  }
  
  override def toString() : String = {
    val result = new StringBuilder
    for (matrix <- matrices) {
      result ++= matrix.toString
      result ++= "\n ------------------ \n"
    }
    result.toString
  }
  
  def toHTML() : Elem = {
    val htmlCode = 
    <html>
    <head>
    		<meta charset="utf-8"/>
    </head>
    <body>
    	{ for(matrix <- matrices) yield matrix.toHTML }
    </body>
    </html>	
    
    htmlCode
  }

  def toPCMModel() : pcmmm.PCM = {
    PcmmmFactory.eINSTANCE.createPCM()
  }

}