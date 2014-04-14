package interpreters

import java.util.regex.Matcher
import pcmmm.Constraint
import pcmmm.Feature
import pcmmm.Product
import pcmmm.PcmmmFactory

class DoublePatternInterpreter (
     validHeaders : List[String],
    regex : String,
    parameters : List[String],
    confident : Boolean)
    extends PatternInterpreter(validHeaders, regex, parameters, confident) {
  
  override def createConstraint(s: String, matcher : Matcher, parameters : List[String], products : List[Product], features : List[Feature]) : Option[Constraint] = {
		  val constraint = PcmmmFactory.eINSTANCE.createDouble()
		
		  constraint.setValue(try {
		    s.toDouble
		  } catch {
		    case e : NumberFormatException => Double.NaN
		    case e : NullPointerException => Double.NaN
		  })
		  
		  constraint.setName(s)
		  constraint.setVerbatim(s)
		  constraint.setConfident(confident)
		  Some(constraint)
    
  }

}