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

fun _LinearLayout.ownerForm() {
	verticalLayout {
		lparams(width = matchParent, height = wrapContent) {
			topMargin = dip(8)
		}

		backgroundColor = Color.WHITE

		textView("Владелец") {
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

			textView("Иванов И. И.") {
				lparams {
					horizontalMargin = dip(16)
					verticalMargin = dip(2)
				}

				textColor = Color.BLACK.withAlpha(0xDE)
				textSize = 16F
			}

			textView("ФИО") {
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

			textView("01.09.1970") {
				lparams {
					horizontalMargin = dip(16)
					verticalMargin = dip(2)
				}

				textColor = Color.BLACK.withAlpha(0xDE)
				textSize = 16F
			}

			textView("Дата рождения") {
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