package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* compiled from: Unknown */
public class f implements Creator<PlusCommonExtras> {
    static void a(PlusCommonExtras plusCommonExtras, Parcel parcel, int i) {
        int p = b.p(parcel);
        b.a(parcel, 1, plusCommonExtras.ho(), false);
        b.c(parcel, 1000, plusCommonExtras.getVersionCode());
        b.a(parcel, 2, plusCommonExtras.hp(), false);
        b.D(parcel, p);
    }

    public PlusCommonExtras aE(Parcel parcel) {
        String str = null;
        int o = a.o(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = a.n(parcel);
            switch (a.S(n)) {
                case 1:
                    str2 = a.m(parcel, n);
                    break;
                case 2:
                    str = a.m(parcel, n);
                    break;
                case 1000:
                    i = a.g(parcel, n);
                    break;
                default:
                    a.b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new PlusCommonExtras(i, str2, str);
        }
        throw new a.a("Overread allowed size end=" + o, parcel);
    }

    public PlusCommonExtras[] bB(int i) {
        return new PlusCommonExtras[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aE(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bB(x0);
    }
}
