package rm.com.driverine.fm

class PredefinedDialogForm<T> : DialogForm<T> {
  var onOpen: T.() -> Unit = {}

  override fun onOpen(owner: T) {
    owner.onOpen()
  }
}