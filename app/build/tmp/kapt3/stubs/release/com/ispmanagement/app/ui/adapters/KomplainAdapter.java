package com.ispmanagement.app.ui.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0015B\'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\b2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0014\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/ispmanagement/app/ui/adapters/KomplainAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ispmanagement/app/ui/adapters/KomplainAdapter$VH;", "items", "", "Lcom/ispmanagement/app/data/TiketKomplain;", "onClick", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "newItems", "VH", "app_release"})
public final class KomplainAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.ispmanagement.app.ui.adapters.KomplainAdapter.VH> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.ispmanagement.app.data.TiketKomplain> items;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.ispmanagement.app.data.TiketKomplain, kotlin.Unit> onClick = null;
    
    public KomplainAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ispmanagement.app.data.TiketKomplain> items, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.ispmanagement.app.data.TiketKomplain, kotlin.Unit> onClick) {
        super();
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ispmanagement.app.data.TiketKomplain> newItems) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.ispmanagement.app.ui.adapters.KomplainAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.ui.adapters.KomplainAdapter.VH holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/ispmanagement/app/ui/adapters/KomplainAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ispmanagement/app/databinding/ItemKomplainBinding;", "(Lcom/ispmanagement/app/ui/adapters/KomplainAdapter;Lcom/ispmanagement/app/databinding/ItemKomplainBinding;)V", "getBinding", "()Lcom/ispmanagement/app/databinding/ItemKomplainBinding;", "app_release"})
    public final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.ispmanagement.app.databinding.ItemKomplainBinding binding = null;
        
        public VH(@org.jetbrains.annotations.NotNull()
        com.ispmanagement.app.databinding.ItemKomplainBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.ispmanagement.app.databinding.ItemKomplainBinding getBinding() {
            return null;
        }
    }
}