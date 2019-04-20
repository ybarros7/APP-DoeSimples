package br.com.pipasdevteam.doesimples.adapters

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import br.com.pipasdevteam.doesimples.R
import br.com.pipasdevteam.doesimples.models.Instituicao
import com.squareup.picasso.Picasso

class InstituicaoAdapter(private val instituicoes: List<Instituicao>, val onClick: (Instituicao) -> Unit) :
    RecyclerView.Adapter<InstituicaoAdapter.InstituicoesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstituicoesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_instituicao, parent, false)
        return InstituicoesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.instituicoes.size
    }

    override fun onBindViewHolder(holder: InstituicoesViewHolder, position: Int) {
        val context = holder.itemView.context
// recuperar objeto disciplina
        val instituicao = instituicoes[position]
// atualizar dados de disciplina
        holder.cardNome.text = instituicao.instituicao
        holder.cardProgress.visibility = View.VISIBLE
// download da imagem
        Picasso.with(context).load(instituicao.foto).fit().into(holder.cardImg,

            object : com.squareup.picasso.Callback {
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }

                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            })

// adiciona evento de clique
        holder.itemView.setOnClickListener { onClick(instituicao) }
    }


    class InstituicoesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardNome: TextView = view.findViewById<TextView>(R.id.cardNome)
        val cardImg: ImageView = view.findViewById<ImageView>(R.id.cardImg)
        var cardProgress: ProgressBar = view.findViewById<ProgressBar>(R.id.cardProgress)
        var cardView: CardView = view.findViewById<CardView>(R.id.card_instituicoes)

    }

}