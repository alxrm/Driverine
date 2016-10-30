package rm.com.driverine.ui.view.form

import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import common.color
import common.selectableBg
import org.jetbrains.anko.*
import rm.com.driverine.R

/**
 * Created by alex
 */

fun _LinearLayout.carForm() {
	verticalLayout {
		lparams(width = matchParent, height = wrapContent) {
			topMargin = dip(8)
		}

		backgroundColor = Color.WHITE

		textView("Автомобиль") {
			lparams {
				topMargin = dip(18)
				bottomMargin = dip(8)
				horizontalMargin = dip(16)
			}

			textColor = color(R.color.color_accent)
			textSize = 14F
			setTypeface(null, Typeface.BOLD)
		}

		verticalLayout {
			lparams(width = matchParent, height = dip(56)) {
				verticalGravity = Gravity.CENTER
			}

			isClickable = true
			backgroundResource = selectableBg()

			textView("BMW") {
				lparams {
					horizontalMargin = dip(16)
					verticalMargin = dip(2)
				}

				textColor = Color.BLACK.withAlpha(0xDE)
				textSize = 16F
			}

			textView("Марка") {
				lparams {
					horizontalMargin = dip(16)
					verticalMargin = dip(2)
				}

				textColor = Color.BLACK.withAlpha(0x8A)
				textSize = 12F
			}
		}

		view {
			lparams(width = matchParent, height = dip(0.5F))
			backgroundColor = color(R.color.color_separator)
		}

		verticalLayout {
			lparams(width = matchParent, height = dip(60)) {
				verticalGravity = Gravity.CENTER
			}

			isClickable = true
			backgroundResource = selectableBg()

			textView("О 997 ОО") {
				lparams {
					horizontalMargin = dip(16)
					verticalMargin = dip(2)
				}

				textColor = Color.BLACK.withAlpha(0xDE)
				textSize = 16F
			}

			textView("Номер") {
				lparams {
					horizontalMargin = dip(16)
					verticalMargin = dip(2)
				}

				textColor = Color.BLACK.withAlpha(0x8A)
				textSize = 12F
			}
		}

		view {
			lparams(width = matchParent, height = dip(0.5F))
			backgroundColor = color(R.color.color_separator)
		}

		verticalLayout {
			lparams(width = matchParent, height = dip(60)) {
				verticalGravity = Gravity.CENTER
			}

			isClickable = true
			backgroundResource = selectableBg()

			textView("Серебристый") {
				lparams {
					horizontalMargin = dip(16)
					verticalMargin = dip(2)
				}

				textColor = Color.BLACK.withAlpha(0xDE)
				textSize = 16F
			}

			textView("Цвет") {
				lparams {
					horizontalMargin = dip(16)
					verticalMargin = dip(2)
				}

				textColor = Color.BLACK.withAlpha(0x8A)
				textSize = 12F
			}
		}
	}
}