package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import com.liapp.y;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class StreamLocalUriFetcher extends LocalUriFetcher<InputStream> {
    private static final int ID_CONTACTS_CONTACT = 3;
    private static final int ID_CONTACTS_LOOKUP = 1;
    private static final int ID_CONTACTS_PHOTO = 4;
    private static final int ID_CONTACTS_THUMBNAIL = 2;
    private static final int ID_LOOKUP_BY_PHONE = 5;
    private static final UriMatcher URI_MATCHER;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        URI_MATCHER = uriMatcher;
        String str = y.ٲٴݴ״ٰ(1781789264);
        uriMatcher.addURI(str, y.ٴسسݬߨ(1392962986), 1);
        uriMatcher.addURI(str, y.ۮڭڭܬި(862095275), 1);
        uriMatcher.addURI(str, y.ۮڭڭܬި(862094851), 2);
        uriMatcher.addURI(str, y.ۮڭڭܬި(862095091), 3);
        uriMatcher.addURI(str, y.ݮڮֲڭܩ(-628958092), 4);
        uriMatcher.addURI(str, y.ݬֲ֮ܲت(1513079663), 5);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StreamLocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public InputStream loadResource(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream loadResourceFromUri = loadResourceFromUri(uri, contentResolver);
        if (loadResourceFromUri != null) {
            return loadResourceFromUri;
        }
        throw new FileNotFoundException(y.ۮڭڭܬި(862093379) + uri);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InputStream loadResourceFromUri(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = URI_MATCHER.match(uri);
        if (match != 1) {
            if (match == 3) {
                return openContactPhotoInputStream(contentResolver, uri);
            }
            if (match != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri lookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (lookupContact == null) {
            throw new FileNotFoundException("Contact cannot be found");
        }
        return openContactPhotoInputStream(contentResolver, lookupContact);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InputStream openContactPhotoInputStream(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public void close(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }
}
