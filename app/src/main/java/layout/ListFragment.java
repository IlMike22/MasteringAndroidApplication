package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mwidlok.masteringandroidapplication.R;
import com.example.mwidlok.masteringandroidapplication.classes.JobOffer;
import com.parse.ParseQueryAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {


	private OnFragmentInteractionListener mListener;

	public ListFragment() {
		// Required empty public constructor
	}


	// TODO: Rename and change types and number of parameters
	public static ListFragment newInstance(String param1, String param2) {
		ListFragment fragment = new ListFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	// TODO: Rename method, update argument and hook method into UI event
	public void onButtonPressed(Uri uri) {
		if (mListener != null) {
			mListener.onFragmentInteraction(uri);
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment

		return inflater.inflate(R.layout.fragment_list, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

		ParseQueryAdapter<JobOffer> parseQueryAdapter = new ParseQueryAdapter<JobOffer>(this.getActivity(), "JobOffer")
		{
			@Override
			public View getItemView(JobOffer jobOffer, View v, ViewGroup parent) {

				if (v == null)
				{
					v = View.inflate(getContext(), R.layout.row_job_offer, null);
				}
				super.getItemView(jobOffer, v, parent);

				TextView tvTitle = (TextView) v.findViewById(R.id.rowJobOfferTitle);
				tvTitle.setText(jobOffer.getTitle());
				TextView tvDescription = (TextView) v.findViewById(R.id.rowJobOfferDesc);
				tvDescription.setText(jobOffer.getDescription());

				return v;
			}
		};


		ListView lvJobOffers = (ListView) view.findViewById(R.id.lvJobOffers);
		lvJobOffers.setAdapter(parseQueryAdapter);


		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated
	 * to the activity and potentially other fragments contained in that
	 * activity.
	 * <p>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnFragmentInteractionListener {
		// TODO: Update argument type and name
		void onFragmentInteraction(Uri uri);
	}
}
