package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* compiled from: Unknown */
public class TileCreator implements Creator<Tile> {
    static void a(Tile tile, Parcel parcel, int i) {
        int p = b.p(parcel);
        b.c(parcel, 1, tile.getVersionCode());
        b.c(parcel, 2, tile.width);
        b.c(parcel, 3, tile.height);
        b.a(parcel, 4, tile.data, false);
        b.D(parcel, p);
    }

    public Tile createFromParcel(Parcel parcel) {
        int i = 0;
        int o = a.o(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = a.n(parcel);
            switch (a.S(n)) {
                case 1:
                    i3 = a.g(parcel, n);
                    break;
                case 2:
                    i2 = a.g(parcel, n);
                    break;
                case 3:
                    i = a.g(parcel, n);
                    break;
                case 4:
                    bArr = a.p(parcel, n);
                    break;
                default:
                    a.b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new a.a("Overread allowed size end=" + o, parcel);
    }

    public Tile[] newArray(int size) {
        return new Tile[size];
    }
}
