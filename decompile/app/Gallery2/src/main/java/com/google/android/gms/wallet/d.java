package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: Unknown */
public final class d implements SafeParcelable {
    public static final Creator<d> CREATOR = new e();
    LoyaltyWalletObject Yj;
    private final int wj;

    d() {
        this.wj = 1;
    }

    d(int i, LoyaltyWalletObject loyaltyWalletObject) {
        this.wj = i;
        this.Yj = loyaltyWalletObject;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        e.a(this, dest, flags);
    }
}
