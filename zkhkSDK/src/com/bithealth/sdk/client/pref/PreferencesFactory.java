package com.bithealth.sdk.client.pref;

import javax.naming.Referenceable;


public interface PreferencesFactory extends Referenceable {
	Preferences getPreferences(String preferencesName);
}
