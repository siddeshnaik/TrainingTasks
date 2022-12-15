package com.example.contactsappwithrecyclerviewcontextresolverfragments

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.provider.ContactsContract
import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class ContactHelper {
    @SuppressLint("Range")
    suspend fun getContactList(context: Context): ArrayList<PhoneContactData> {
        val phoneContactDataFunc = ArrayList<PhoneContactData>()

        Log.i("SiddeshThreads", Thread.currentThread().name)

            val cr = context.contentResolver
            val cur: Cursor? = cr.query(
                ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null
            )
//        delay(10000)
            if ((cur?.count ?: 0) > 0) {
                while (cur != null && cur.moveToNext()) {
                    val id: String = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts._ID)

                    )

//                val contact_Photo:InputStream? = openPhoto(id.toLong())

                    val name: String = cur.getString(
                        cur.getColumnIndex(
                            ContactsContract.Contacts.DISPLAY_NAME
                        )
                    )

                    val staredContact: String = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.STARRED))



                    if (cur.getInt(
                            cur.getColumnIndex(
                                ContactsContract.Contacts.HAS_PHONE_NUMBER
                            )
                        ) > 0
                    ) {
                        val pCur: Cursor? = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            arrayOf(id),
                            null
                        )
                        if (pCur != null) {
                            while (pCur.moveToNext()) {
                                val phoneNo: String = pCur.getString(
                                    pCur.getColumnIndex(
                                        ContactsContract.CommonDataKinds.Phone.NUMBER
                                    )
                                )
//                            Log.i("Name", "$name")
//                            Log.i("Phone Number", "$phoneNo")
//                            phoneContactDataFunc.add(PhoneContactData(name, phoneNo, id, contact_Photo))
                                phoneContactDataFunc.add(
                                    PhoneContactData(
                                        name,
                                        phoneNo,
                                        id,
                                        staredContact
                                    )
                                )
                            }
                        }


                        pCur?.close()
                    }
                }
            }
            cur?.close()




        return phoneContactDataFunc




    }

    @SuppressLint("Range")
    suspend fun getFavContactList(context: Context): ArrayList<PhoneContactData> {


        val phoneContactDataStared = ArrayList<PhoneContactData>()




            val cr = context.contentResolver
            val cur: Cursor? = cr.query(
                ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null
            )




            if ((cur?.count ?: 0) > 0) {
                while (cur != null && cur.moveToNext()) {
                    val id: String = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts._ID)

                    )

//                val contact_Photo:InputStream? = openPhoto(id.toLong())

                    val name: String = cur.getString(
                        cur.getColumnIndex(
                            ContactsContract.Contacts.DISPLAY_NAME
                        )
                    )

                    val staredContact: String = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.STARRED))



                    if (cur.getInt(
                            cur.getColumnIndex(
                                ContactsContract.Contacts.HAS_PHONE_NUMBER
                            )
                        ) > 0
                    ) {
                        val pCur: Cursor? = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            arrayOf(id),
                            null
                        )
                        if (pCur != null &&  staredContact=="1") {
                            while (pCur.moveToNext()) {
                                val phoneNo: String = pCur.getString(
                                    pCur.getColumnIndex(
                                        ContactsContract.CommonDataKinds.Phone.NUMBER
                                    )
                                )


                                phoneContactDataStared.add(
                                    PhoneContactData(
                                        name,
                                        phoneNo,
                                        id,
                                        staredContact
                                    )
                                )
                            }
                        }


                        pCur?.close()
                    }
                }
            }
            cur?.close()




        return phoneContactDataStared




    }

}