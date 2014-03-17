package interpreters

import java.util.regex.Matcher
import pcmmm.Constraint
import pcmmm.PcmmmFactory

class EmptyPatternInterpreter (
    validRowHeaders : List[String],
    validColumnHeaders : List[String],
    regex : String,
    parameters : List[String])
    extends PatternInterpreter(validRowHeaders, validColumnHeaders, regex, parameters) {

  override def createConstraint(matcher : Matcher, parameters : List[String]) : Constraint = {
		  PcmmmFactory.eINSTANCE.createEmpty()
  }

}