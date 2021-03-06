package application.davidelmn.swipetodeleteundorecyclerviewlibrary.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import application.davidelmn.swipetodeleteundorecyclerviewlibrary.R

/**
 * Created by davide-syn on 9/27/17.
 */
open class DeletableVh(view: View) : RecyclerView.ViewHolder(LayoutInflater.from(view.context).inflate(R.layout.row_view, view.rootView as ViewGroup, false)) {
    private val mainView: ViewGroup = itemView.findViewById(R.id.mainViewLayoutContainerId)
    private val undoButton: Button = itemView.findViewById(R.id.undo_button)

    init {
        mainView.addView(view)
    }

    /**
     *
     * @param undoButtonEnabled
     */
    fun setUndoButtonEnabled(listener: View.OnClickListener, undoButtonEnabled: Boolean) {
        Log.e(javaClass.name, if (undoButtonEnabled) "ENABLE" else "NOT")

        if (undoButtonEnabled) {
            undoButton.visibility = View.VISIBLE
            undoButton.setOnClickListener(listener)
            mainView.visibility = View.GONE
//            mainView.x = -400F
            return
        }
        undoButton.visibility = View.GONE
        undoButton.setOnClickListener(null)
        mainView.x = 0F
    }
}
