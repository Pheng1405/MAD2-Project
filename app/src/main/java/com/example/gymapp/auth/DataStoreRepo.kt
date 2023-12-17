package com.example.gymapp.auth
//
//import androidx.datastore.core.DataStore
//import androidx.datastore.preferences.core.Preferences
//import androidx.datastore.preferences.core.edit
//import androidx.datastore.preferences.core.stringPreferencesKey
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.map
//import javax.inject.Inject

//class PreferencesRepository @Inject constructor(private val dataStore: DataStore<Preferences>) {
//
//    private val exampleKey = stringPreferencesKey("token")
//
//    val exampleValue: Flow<String?> = dataStore.data
//        .map { preferences ->
//            preferences[exampleKey]
//        }
//
//    suspend fun saveExampleValue(value: String) {
//        dataStore.edit { preferences ->
//            preferences[exampleKey] = value
//        }
//    }
//}