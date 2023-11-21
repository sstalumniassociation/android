package org.sstaa.sstalumni

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

private const val TITLE = "TITLE"
private const val DESCRIPTION = "DESCRIPTION"
private const val IMAGE_RESOURCE = "IMAGE_RESOURCE"
class OnboardingFragment : Fragment() {
    private var title: String? = null
    private var description: String? = null
    private var imageResource: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(TITLE)
            description = it.getString(DESCRIPTION)
            imageResource = it.getInt(IMAGE_RESOURCE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_onboarding, container, false)

        // Fill in the icon, title, and description
        view.findViewById<android.widget.ImageView>(R.id.onboarding_icon).setImageResource(imageResource!!)
        view.findViewById<android.widget.TextView>(R.id.onboarding_title).text = title
        view.findViewById<android.widget.TextView>(R.id.onboarding_description).text = description

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(title: String, description: String, imageResource: Int) =
            OnboardingFragment().apply {
                arguments = Bundle().apply {
                    putString(TITLE, title)
                    putString(DESCRIPTION, description)
                    putInt(IMAGE_RESOURCE, imageResource)
                }
            }
    }
}