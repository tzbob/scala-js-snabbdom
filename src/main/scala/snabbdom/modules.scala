package snabbdom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
trait SnabbModule extends js.Object

@JSImport("snabbdom/modules/attributes", JSImport.Default)
@js.native
object attributes extends SnabbModule

@JSImport("snabbdom/modules/class", JSImport.Default)
@js.native
object `class` extends SnabbModule

@JSImport("snabbdom/modules/dataset", JSImport.Default)
@js.native
object dataset extends SnabbModule

@JSImport("snabbdom/modules/eventlisteners", JSImport.Default)
@js.native
object eventlisteners extends SnabbModule

@JSImport("snabbdom/modules/hero", JSImport.Default)
@js.native
object hero extends SnabbModule

@JSImport("snabbdom/modules/props", JSImport.Default)
@js.native
object props extends SnabbModule

@JSImport("snabbdom/modules/style", JSImport.Default)
@js.native
object style extends SnabbModule
