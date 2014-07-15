package controller

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.mutable.Specification
import play.api.test.{FakeRequest, WithApplication}
import controllers.Start
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class StartControllerSpec extends Specification {

  "Start" should {
    "present" in new WithApplication{
      val result = Start.present(FakeRequest())
      status(result) should beEqualTo(OK)
    }
  }
}
