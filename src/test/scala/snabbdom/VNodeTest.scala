package snabbdom

import org.scalajs.dom
import org.scalajs.dom.raw.Element
import org.scalatest.FunSuite

import scala.scalajs.js
import scala.scalajs.js.Any
import scala.scalajs.js.JSConverters._

class VNodeTest extends FunSuite {

  private def patchNode(vnode: VNode, vnodes: VNode*): Element = {
    val container = dom.document.createElement("div")
    val target    = dom.document.createElement("div")
    container.appendChild(target)
    dom.document.body.appendChild(container)

    val patch = Snabbdom.init(
      List(
        style,
        props
      ).toJSArray)

    val firstPatch = patch(target, vnode)

    vnodes.foldLeft(firstPatch) { (acc, vnode) =>
      patch(acc, vnode)
    }
    container
  }

  test("Snabbdom's patch is available through init") {
    val vnode     = h("p", Some("ABC": Any).orUndefined)
    val container = patchNode(vnode)
    assert(container.innerHTML === "<p>ABC</p>")
  }

  import scala.scalajs.js.UndefOr.{any2undefOrA => toUndef}

  test("test passing of modules: style module") {
    // h('span', {style: {fontWeight: 'bold'}}, 'This is bold')
    val style = js.Dictionary("style" -> js.Dictionary("fontWeight" -> "bold"))
    val vnode = h("p", style, toUndef("This is bold"))

    val container = patchNode(vnode)
    val element   = container.children(0)

    assert(element.getAttribute("style") === "font-weight: bold;")
    assert(element.innerHTML === "This is bold")
  }

  test("test hooks: destroy hook") {

    var initialized = false
    val initHook: js.Function1[VNode, Unit] = (vnode: VNode) => {
      initialized = true
    }

    var destroyed = false
    val destroyHook: js.Function1[VNode, Unit] = (vnode: VNode) => {
      destroyed = true
    }

    val hooks = js.Dictionary(
      "hook" -> js.Dictionary("destroy" -> destroyHook, "init" -> initHook))

    val vnode1    = h("div", List(h("span", hooks, toUndef("Hello"))).toJSArray)
    val vnode2    = h("div")
    val container = patchNode(vnode1, vnode2)

    assert(initialized)
    assert(destroyed)
  }

}
