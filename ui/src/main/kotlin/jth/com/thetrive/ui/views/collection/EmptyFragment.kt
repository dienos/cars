package jth.com.thetrive.ui.views.collection

import jth.com.thetrive.ui.R
import jth.com.thetrive.ui.databinding.EmptyFragmentBinding
import jth.com.thetrive.ui.views.base.BaseFragment

class EmptyFragment : BaseFragment<EmptyFragmentBinding>() {
    override fun getLayoutResId(): Int = R.layout.empty_fragment

    override fun initializeUi() {
    }

    override fun initializeUiEvent() {

    }

    override fun initializeViewModel() {
    }
}