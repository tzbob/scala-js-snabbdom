package snabbdom

import org.scalajs.dom.{Element, Text}

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSImport}
import scala.scalajs.js.annotation.JSImport.Namespace
import scala.scalajs.js.|

@JSImport("snabbdom", Namespace)
@js.native
object Snabbdom extends js.Object {
  def init(modules: js.Array[SnabbModule])
    : js.Function2[VNode | Element, VNode, VNode] = js.native
}

@JSImport("snabbdom/h", JSImport.Default)
@js.native
object h
    extends js.Function3[String, js.UndefOr[js.Any], js.UndefOr[js.Any], VNode] {
  def apply(selector: String,
            b: js.UndefOr[js.Any] = js.undefined,
            c: js.UndefOr[js.Any] = js.undefined): VNode = js.native
}

@js.native
@JSGlobal
class VNode(
    val selector: js.UndefOr[String],
    val data: js.UndefOr[VNodeData],
    val children: js.UndefOr[js.Array[VNode | String]],
    val text: js.UndefOr[String],
    val elm: js.UndefOr[Element | Text],
    val key: js.UndefOr[String | Double]
) extends js.Object

@js.native
@JSGlobal
class VNodeData extends js.Object
