package rm.com.driverine.ui.item

import android.graphics.Color
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import common.imageDrawable
import common.lparamsRel
import common.selectableBg
import common.vectorOf
import org.jetbrains.anko.*
import rm.com.driverine.R
import rm.com.driverine.data.model.Car
import rm.com.driverine.data.model.Relative
import rm.com.driverine.ui.holder.DriverHolder
import rm.com.driverine.util.ext.formatName
import rm.com.driverine.util.ext.inflateOptional
import rm.com.driverine.util.ext.toReadableString

/**
 * Created by alex
 */

fun ViewGroup?.driverItemView(): View? =
    inflateOptional {
      relativeLayout {
        lparams(width = matchParent, height = dip(72))

        isClickable = true
        backgroundResource = selectableBg()

        verticalLayout {
          lparams(height = matchParent) {
            verticalPadding = dip(16)
          }

          id = R.id.driver_credits

          textView {
            lparams {
              horizontalMargin = dip(16)
            }

            id = R.id.driver_name
            textColor = Color.BLACK.withAlpha(0xDE)
            textSize = 16F
          }

          textView {
            lparams {
              horizontalMargin = dip(16)
            }

            id = R.id.driver_birth
            textColor = Color.BLACK.withAlpha(0x8A)
            textSize = 14F
          }
        }

        imageView {
          lparams(width = dip(48), height = dip(48)) {
            centerVertically()
            alignParentEnd()
            horizontalMargin = dip(12)
            padding = dip(12)
          }

          id = R.id.driver_car
          backgroundResource = R.drawable.bg_clickable
          imageDrawable = vectorOf(R.drawable.ic_car_24dp)
          isClickable = true
        }

        imageView {
          lparams(width = dip(48), height = dip(48)) {
            centerVertically()
            leftOf(R.id.driver_car)
            padding = dip(12)
          }

          id = R.id.driver_relatives
          backgroundResource = R.drawable.bg_clickable
          imageDrawable = vectorOf(R.drawable.ic_people_24dp)
          isClickable = true
        }
      }
    }

fun DriverHolder.carDialog(car: Car) = with(itemView!!.context) {
  alert {
    title("Автомобиль")

    customView {
      relativeLayout {
        horizontalPadding = dip(20)
        verticalPadding = dip(12)

        imageView {
          id = R.id.driver_car
          imageDrawable = vectorOf(R.drawable.ic_car_24dp)
        }

        textView {
          lparams {
            rightOf(R.id.driver_car)
            horizontalMargin = dip(16)
          }

          id = R.id.driver_car_info
          text = "Марка\n\nЦвет\n\nНомер"
          textSize = 16F
          setTypeface(null, Typeface.BOLD)
        }


        textView {
          lparams {
            rightOf(R.id.driver_car_info)
            horizontalMargin = dip(16)
          }

          text = "${car.brand}\n\n${car.color}\n\n${car.number}"
          textSize = 16F
        }
      }
    }

    yesButton {
      dismiss()
    }

    show()
  }
}

fun DriverHolder.relativesDialog(relatives: List<Relative>) = with(itemView!!.context) {
  alert {
    title("Родственники")

    customView {
      relativeLayout {
        horizontalPadding = dip(20)
        verticalPadding = dip(12)

        if (relatives.isEmpty()) {
          textView {
            lparams { centerInParent() }

            textSize = 18F
            text = "Родственники не указаны"
          }

          return@relativeLayout
        }

        imageView {
          id = R.id.driver_relatives
          imageDrawable = vectorOf(R.drawable.ic_people_24dp)
        }

        verticalLayout {
          lparamsRel {
            rightOf(R.id.driver_relatives)
            horizontalMargin = dip(16)
          }

          relatives.forEach {
            textView {
              text = "${it.type.toReadableString()} — ${it.relative?.formatName().orEmpty()}"
              textSize = 16F
            }
          }
        }
      }
    }

    yesButton {
      dismiss()
    }

    show()
  }
}
