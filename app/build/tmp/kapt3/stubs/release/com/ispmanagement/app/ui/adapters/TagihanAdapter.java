package com.ispmanagement.app.ui.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\b2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0014\u0010\u0015\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/ispmanagement/app/ui/adapters/TagihanAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ispmanagement/app/ui/adapters/TagihanAdapter$VH;", "items", "", "Lcom/ispmanagement/app/data/Tagihan;", "onBayarClick", "Lkotlin/Function1;", "", "btnLabel", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "newItems", "VH", "app_release"})
public final class TagihanAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.ispmanagement.app.ui.adapters.TagihanAdapter.VH> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.ispmanagement.app.data.Tagihan> items;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.ispmanagement.app.data.Tagihan, kotlin.Unit> onBayarClick = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String btnLabel = null;
    
    public TagihanAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ispmanagement.app.data.Tagihan> items, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.ispmanagement.app.data.Tagihan, kotlin.Unit> onBayarClick, @org.jetbrains.annotations.NotNull()
    java.lang.String btnLabel) {
        super();
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ispmanagement.app.data.Tagihan> newItems) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.ispmanagement.app.ui.adapters.TagihanAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.ui.adapters.TagihanAdapter.VH holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/ispmanagement/app/ui/adapters/TagihanAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ispmanagement/app/databinding/ItemTagihanBinding;", "(Lcom/ispmanagement/app/ui/adapters/TagihanAdapter;Lcom/ispmanagement/app/databinding/ItemTagihanBinding;)V", "getBinding", "()Lcom/ispmanagement/app/databinding/ItemTagihanBinding;", "app_release"})
    public final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.ispmanagement.app.databinding.ItemTagihanBinding binding = null;
        
        public VH(@org.jetbrains.annotations.NotNull()
        com.ispmanagement.app.databinding.ItemTagihanBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.ispmanagement.app.databinding.ItemTagihanBinding getBinding() {
            return null;
        }
    }
}