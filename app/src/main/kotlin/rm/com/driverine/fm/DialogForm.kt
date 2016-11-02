package rm.com.driverine.fm

/**
 * Created by alex
 */

interface DialogForm<T> {
  fun onOpen(owner: T)
}