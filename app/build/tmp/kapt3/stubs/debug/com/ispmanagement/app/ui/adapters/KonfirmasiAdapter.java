package com.ispmanagement.app.ui.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001aB;\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\b2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0014\u0010\u0014\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/ispmanagement/app/ui/adapters/KonfirmasiAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ispmanagement/app/ui/adapters/KonfirmasiAdapter$VH;", "items", "", "Lcom/ispmanagement/app/data/Tagihan;", "onTerima", "Lkotlin/Function1;", "", "onTolak", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "newItems", "tampilkanDetailDialog", "context", "Landroid/content/Context;", "t", "VH", "app_debug"})
public final class KonfirmasiAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.ispmanagement.app.ui.adapters.KonfirmasiAdapter.VH> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.ispmanagement.app.data.Tagihan> items;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.ispmanagement.app.data.Tagihan, kotlin.Unit> onTerima = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.ispmanagement.app.data.Tagihan, kotlin.Unit> onTolak = null;
    
    public KonfirmasiAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ispmanagement.app.data.Tagihan> items, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.ispmanagement.app.data.Tagihan, kotlin.Unit> onTerima, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.ispmanagement.app.data.Tagihan, kotlin.Unit> onTolak) {
        super();
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ispmanagement.app.data.Tagihan> newItems) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.ispmanagement.app.ui.adapters.KonfirmasiAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.ui.adapters.KonfirmasiAdapter.VH holder, int position) {
    }
    
    private final void tampilkanDetailDialog(android.content.Context context, com.ispmanagement.app.data.Tagihan t) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/ispmanagement/app/ui/adapters/KonfirmasiAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ispmanagement/app/databinding/ItemKonfirmasiPembayaranBinding;", "(Lcom/ispmanagement/app/ui/adapters/KonfirmasiAdapter;Lcom/ispmanagement/app/databinding/ItemKonfirmasiPembayaranBinding;)V", "getBinding", "()Lcom/ispmanagement/app/databinding/ItemKonfirmasiPembayaranBinding;", "app_debug"})
    public final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.ispmanagement.app.databinding.ItemKonfirmasiPembayaranBinding binding = null;
        
        public VH(@org.jetbrains.annotations.NotNull()
        com.ispmanagement.app.databinding.ItemKonfirmasiPembayaranBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.ispmanagement.app.databinding.ItemKonfirmasiPembayaranBinding getBinding() {
            return null;
        }
    }
}